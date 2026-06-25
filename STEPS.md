# STEPS — Expense Tracker, Session 2

Postupný průvodce / step-by-step guide. Pracuješ v **jednom** Maven projektu (tomhle).
Otevři ho jednou a postupně doplňuj kód podle kroků 1–7 níže.

You work in **one** Maven project (this one). Open it once and fill in the code
step by step, following steps 1–7 below.

---

## Jak začít / Getting started

1. **Otevři projekt / Open the project**
   IntelliJ IDEA → **File → Open** → vyber **kořenovou složku repozitáře** (ta, kde je `pom.xml`).
   *(Select the repository root folder — the one containing `pom.xml`. Not a sub-folder.)*
   Počkej, až IntelliJ stáhne závislosti.

2. **Spusť aplikaci / Run the app**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Swagger UI**
   <http://localhost:8080/swagger-ui/index.html> — tady testuješ API v prohlížeči.

4. **Ověř data v DB / Inspect the database** (od kroku 1 dál / from step 1 on)
   ```bash
   sqlite3 expenses.db ".tables"
   sqlite3 expenses.db "SELECT * FROM expenses;"
   ```

> **Zasekl ses? / Stuck?** Přepni na větev **`final`** a podívej se na kompletní řešení:
> ```bash
> git switch final     # kompletní řešení / the full solution
> git switch main      # zpět ke svému zadání / back to your work
> ```

**Výchozí stav / Starting point:** funkční REST API ze Session 1 — data v `HashMap` (zmizí po restartu).
Kód je posetý značkami `// STEP N — …`. Každá značka je místo, kde budeš psát kód.

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
- `ExpenseController.kt` se **NEMĚNÍ** — to je pointa architektury ze Session 1.

**Hotovo když… / Done when…** přidáš výdaj přes `POST /expenses`, **restartuješ** appku a `GET /expenses`
ho pořád vrací. Data jsou v `expenses.db`.

---

## Step 5 — Bean Validation (@Valid)

**Cíl / Goal:** API odmítne nevalidní vstup (prázdný popis, záporná částka) s `400`.

**Co udělat / What to do:**
- `pom.xml` — odkomentuj blok **STEP 5** (`spring-boot-starter-validation`).
- `CreateExpenseRequest.kt` — `@field:NotBlank` + `@field:Size(min=2,max=100)` na `description`,
  `@field:Min(1)` na `amount` (s anglickými chybovými hláškami).
- `ExpenseController.kt` — přidej `@Valid` před `@RequestBody` v metodě `add`.

**Hint:**
```kotlin
@field:NotBlank(message = "Description must not be empty")
@field:Size(min = 2, max = 100, message = "Description must be 2-100 characters")
val description: String,
@field:Min(value = 1, message = "Amount must be at least 1 CZK")
val amount: Int
```

**Hotovo když… / Done when…** `POST` s `{"description":"","amount":-5}` vrátí **400** (ne 200).

---

## Step 6 — Error handling

**Cíl / Goal:** jednotné chybové odpovědi v JSON formátu (`status` / `error` / `message`).

**Co udělat / What to do:**
- `ExpenseNotFoundException.kt` — `class ExpenseNotFoundException(id: Int) : RuntimeException("Expense with ID $id not found")`.
- `GlobalExceptionHandler.kt` — `@RestControllerAdvice` + `data class ErrorResponse(...)` a handlery:
  - `MethodArgumentNotValidException` → **400**,
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

## Step 7 — OpenAPI finalization

**Cíl / Goal:** produkční Swagger dokumentace — popisy, příklady, chybové kódy.

**Co udělat / What to do:**
- `Expense.kt` a `CreateExpenseRequest.kt` — přidej `@Schema(description = …, example = …)` na třídy i pole.
- `ExpenseController.kt` — přidej `@ApiResponses` na endpointy (200, a u `add` 400, u `findById` 404).

**Hint:**
```kotlin
@Schema(description = "Amount in CZK", example = "150")
val amount: Int
// ...
@ApiResponses(
    ApiResponse(responseCode = "200", description = "Expense added successfully"),
    ApiResponse(responseCode = "400", description = "Invalid request — validation failed")
)
```

**Hotovo když… / Done when…** Swagger UI ukazuje popisy polí, příklady a chybové kódy
u jednotlivých endpointů (`/swagger-ui/index.html`).

---

🎉 **Hotovo!** Máš produkční API: SQLite perzistence, validace, jednotné chyby a Swagger dokumentaci —
a `ExpenseController` se od Session 1 prakticky nezměnil. Kompletní řešení: větev **`final`**.
