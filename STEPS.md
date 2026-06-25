# STEPS — Expense Tracker, Session 2

Postupný průvodce / step-by-step guide. Pracuješ v **jednom** Maven projektu na větvi **`start`**.
Přepni se na ni a postupně doplňuj kód podle kroků 1–7 níže.

You work in **one** Maven project on the **`start`** branch. Switch to it and fill in the code
step by step, following steps 1–7 below. The complete solution is on **`main`** (and **`final`**).

---

## Jak začít / Getting started

1. **Přepni se na zadání / Switch to the tasks**
   ```bash
   git switch start
   ```

2. **Otevři projekt / Open the project**
   IntelliJ IDEA → **File → Open** → vyber **kořenovou složku repozitáře** (ta, kde je `pom.xml`).
   *(Select the repository root folder — the one containing `pom.xml`. Not a sub-folder.)*
   Počkej, až IntelliJ stáhne závislosti.

3. **Spusť aplikaci / Run the app**
   ```bash
   ./mvnw spring-boot:run
   ```
   SQLite se **neinstaluje** — driver `sqlite-jdbc` je závislost v `pom.xml` a soubor
   `expenses.db` si appka vytvoří sama při startu (od kroku 1 dál).

4. **Swagger UI**
   <http://localhost:8080/swagger-ui/index.html> — tady testuješ API v prohlížeči.

5. **Ověř data v DB / Inspect the database** (od kroku 1 dál / from step 1 on)
   ```bash
   sqlite3 expenses.db ".tables"
   sqlite3 expenses.db "SELECT * FROM expenses;"
   ```
   *(`sqlite3` CLI je volitelný — slouží jen k prohlížení dat, appka ho nepotřebuje.)*

> **Zasekl ses? / Stuck?** Kompletní řešení je na větvi **`main`** (i na **`final`**):
> ```bash
> git switch main      # kompletní řešení / the full solution (= final)
> git switch start     # zpět ke svému zadání / back to your work
> ```

**Výchozí stav / Starting point:** funkční REST API ze Session 1 — data v `HashMap` (zmizí po restartu).
Kód je posetý značkami `// STEP N — …`. Každá značka je místo, kde budeš psát kód.

---

## Jak teče request / The request flow

Než začneš, ujasni si **vrstvy** — každý request jimi protéká shora dolů:

```
HTTP  →  ExpenseController  →  ExpenseService  →  ExpenseRepository  →  SQLite
         (@RestController)     (business logika)   (JdbcTemplate, SQL)   (expenses.db)
```

- **Controller** (`ExpenseController.kt`) — vstupní bod: mapuje `GET/POST/DELETE /expenses` na metody
  a deleguje na service. Tělo requestu (`CreateExpenseRequest`) si nechá zmapovat z JSON.
- **Service** (`ExpenseService.kt`) — business logika; neví nic o HTTP ani o SQL.
- **Repository** (`ExpenseRepository.kt`) — jediná vrstva, co mluví s databází (SQL přes `JdbcTemplate`).

Tahle separace je pointa: v kroku 4 vyměníš `HashMap` za databázi a **controller se nezmění ani o řádek**.

---

## Step 1 — SQLite setup & schema

**Cíl / Goal:** přidat SQLite databázi (soubor na disku), aby data přežila restart.

**Co udělat / What to do:**
- `pom.xml` — odkomentuj blok **STEP 1** (závislosti `sqlite-jdbc` + `spring-boot-starter-jdbc`).
- `src/main/resources/application.yaml` — odkomentuj blok **STEP 1** (`spring.datasource` + `spring.sql.init`).
- `src/main/resources/schema.sql` — napiš `CREATE TABLE` pro tabulku `expenses`.

**Hint:**
```sql
CREATE TABLE IF NOT EXISTS expenses (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    description TEXT NOT NULL, amount INTEGER NOT NULL, date TEXT NOT NULL
);
```

**Hotovo když… / Done when…** aplikace nastartuje a vznikne soubor `expenses.db`:
`ls -la expenses.db` ho ukáže, `sqlite3 expenses.db ".tables"` vypíše `expenses`.

---

## Step 2 — Repository: save() + findAll()

**Cíl / Goal:** datová vrstva nad SQLite pomocí `JdbcTemplate`.

**Co udělat / What to do:**
- `ExpenseRepository.kt` — vytvoř třídu `@Repository` s injektovaným `JdbcTemplate` a naimplementuj:
  - `save(description, amount, date): Expense` — `INSERT` a vrať řádek s vygenerovaným `id`.
  - `findAll(): List<Expense>` — `SELECT * FROM expenses ORDER BY id`.

**Hint:**
```kotlin
@Repository
class ExpenseRepository(private val jdbc: JdbcTemplate) {
    fun save(...): Expense { /* GeneratedKeyHolder -> new id */ }
    fun findAll(): List<Expense> = jdbc.query("SELECT * FROM expenses ORDER BY id") { rs, _ -> Expense(...) }
}
```

**Hotovo když… / Done when…** kód se zkompiluje; `findAll()` a `save()` existují (zapojíme je v kroku 4).

---

## Step 3 — Repository: findById() + delete()

**Cíl / Goal:** dokončit CRUD — vyhledání jednoho záznamu a mazání.

**Co udělat / What to do:**
- `ExpenseRepository.kt` — přidej:
  - `findById(id): Expense?` — `queryForObject`; když nic nenajde, vrať `null`.
  - `delete(id): Boolean` — `DELETE`; vrať `true`, pokud se něco smazalo.

**Hint:** `queryForObject` vyhodí `EmptyResultDataAccessException`, když nic nenajde — odchyť ji a vrať `null`.
```kotlin
try { jdbc.queryForObject("SELECT * FROM expenses WHERE id = ?", { rs, _ -> Expense(...) }, id) }
catch (e: EmptyResultDataAccessException) { null }

fun delete(id: Int): Boolean = jdbc.update("DELETE FROM expenses WHERE id = ?", id) > 0
```

**Hotovo když… / Done when…** repository má všechny čtyři metody a projekt se kompiluje.

---

## Step 4 — Service → Repository

**Cíl / Goal:** přepojit `ExpenseService` z `HashMap` na repository → **data přežijí restart**.

**Co udělat / What to do:**
- `ExpenseService.kt` — smaž `HashMap`/`nextId`, injektuj repository a deleguj na něj:
  ```kotlin
  @Service
  class ExpenseService(private val repository: ExpenseRepository) {
      fun add(d: String, a: Int) = repository.save(d, a, "2024-01-15")
      fun getAll() = repository.findAll()
      // findById / delete / total → repository
  }
  ```
- `ExpenseController.kt` se v tomhle kroku **NEMĚNÍ** — to je pointa vrstvené architektury ze
  Session 1 (controller volá service, service repository). Měnit ho budeš až u OpenAPI v kroku 5.

**Hotovo když… / Done when…** přidáš výdaj přes `POST /expenses`, **restartuješ** appku a `GET /expenses`
ho pořád vrací. Data jsou v `expenses.db`.

---

## Step 5 — OpenAPI / Swagger (+ živé demo)

**Cíl / Goal:** produkční Swagger dokumentace — popisy, příklady, stavové kódy — a **živé demo** API.

**Co udělat / What to do:**
- `Expense.kt` a `CreateExpenseRequest.kt` — přidej `@Schema(description = …, example = …)` na třídy i pole.
- `ExpenseController.kt` — přidej `@ApiResponse(s)` na endpointy (200; u `findById` i 404).

**Hint:**
```kotlin
@Schema(description = "Amount in CZK", example = "150")
val amount: Int
// ...
@ApiResponse(responseCode = "200", description = "Expense added successfully")
```

**Hotovo když… / Done when…** Swagger UI na <http://localhost:8080/swagger-ui/index.html> ukazuje
popisy polí a příklady. **Živé demo:** rozklikni `POST /expenses` → *Try it out* → *Execute*,
pak `GET /expenses` — projedeš celý **request flow Controller → Service → Repository → SQLite**.

---

## Step 6 (BONUS) — Error handling

> 🎁 Bonus na konec — když zbyde čas. Bez něj API funguje; jen vrací defaultní chybovou odpověď
> místo hezkého JSON.

**Cíl / Goal:** jednotné chybové odpovědi v JSON formátu (`status` / `error` / `message`).

**Co udělat / What to do:**
- `ExpenseNotFoundException.kt` — `class ExpenseNotFoundException(id: Int) : RuntimeException("Expense with ID $id not found")`.
- `GlobalExceptionHandler.kt` — `@RestControllerAdvice` + `data class ErrorResponse(...)` a handlery:
  - `ExpenseNotFoundException` → **404**,
  - `Exception` → **500**.
- `ExpenseController.kt` — v `findById` místo `ResponseEntity.notFound()` **vyhoď** `ExpenseNotFoundException(id)`;
  návratový typ se zjednoduší na `Expense`.

**Hint:**
```kotlin
@GetMapping("/{id}")
fun findById(@PathVariable id: Int): Expense =
    service.findById(id) ?: throw ExpenseNotFoundException(id)
```

**Hotovo když… / Done when…** `GET /expenses/9999` vrátí **404** s JSON tělem
`{"status":404,"error":"Not Found","message":"Expense with ID 9999 not found"}`.

---

🎉 **Hotovo!** Máš produkční API: SQLite perzistence, čistý flow Controller → Service → Repository
a Swagger dokumentaci (+ bonusový error handling). Kompletní řešení: větev **`main`** (i **`final`**).
