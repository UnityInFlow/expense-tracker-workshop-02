# Expense Tracker Workshop — Session 2

## SQLite + Repository + Swagger

A follow-up workshop to Session 1. You take the request through the whole stack —
**Controller → Service → Repository → SQLite** — make the data survive a restart, and document
it with Swagger/OpenAPI (plus a bonus error handler). The core of the Controller doesn't change —
that validates the layered architecture from Session 1.

Navazující workshop na Session 1. Provedeš request celým řezem **Controller → Service → Repository →
SQLite**, data přežijí restart a zdokumentuješ je Swaggerem (+ bonusový error handling).
Jádro `ExpenseController`u se nemění — to potvrzuje vrstvenou architekturu ze Session 1.

---

## How this repository works / Jak repozitář funguje

**One Maven project. One folder. Seven steps.** Otevřeš **jeden** projekt a postupně doplňuješ kód.

- **`start` branch** — the project in its **starting state** (working Session-1 API, data in a `HashMap`).
  The code is marked with `// STEP N — …` comments + `// TODO`s showing exactly where you write code.
  **Začni tady:** `git switch start`.
- **`main` (= `final` branch)** — the **complete solution** (the same single project, fully implemented).
  Each `// STEP N — …` comment sits above the code that step adds. Sem se podívej, když se zasekneš.

There are **no** `step-NN` folders anymore. Switch to **`start`**, open the repo root and follow
[**STEPS.md**](STEPS.md) from step 1 to step 7.

---

## How to run / Jak to spustit

> **Workshop participants / Účastníci:** začni na větvi **`start`** (`git switch start`) a vyplňuj
> kód podle [STEPS.md](STEPS.md). Kroky níže fungují stejně na kterékoli větvi.

1. **Open the project / Otevři projekt**
   IntelliJ IDEA → **File → Open** → select the **repository root folder** (the one with `pom.xml`).
   Vyber **kořenovou složku** repozitáře (tu, kde je `pom.xml`) — ne podsložku. Počkej na stažení závislostí.

2. **Run / Spusť**
   ```bash
   ./mvnw spring-boot:run
   ```
   (Windows: `mvnw.cmd spring-boot:run`. Or just press ▶ on `Application.kt` in IntelliJ.)

3. **Open Swagger UI / Otevři Swagger**
   <http://localhost:8080/swagger-ui/index.html> — test the API in your browser.

4. **Inspect the database / Podívej se do DB** (from step 1 on / od kroku 1)
   ```bash
   sqlite3 expenses.db ".tables"
   sqlite3 expenses.db "SELECT * FROM expenses;"
   ```

> **Stuck? / Zasekl ses?** The complete solution is on **`main`** (and the **`final`** branch):
> ```bash
> git switch main      # complete solution / kompletní řešení (= final)
> git switch start     # back to your work / zpět ke svému zadání
> ```

---

## Test the API / Otestuj API

Two ready-made ways to exercise the endpoints (app must be running):

- **`expense-tracker.http`** — open in IntelliJ and click the green ▶ next to each request
  (built-in HTTP Client; `> {% ... %}` blocks assert the status/body).
- **`smoke-test.sh`** — runs all the curl checks with ✅/❌:
  ```bash
  ./smoke-test.sh            # http://localhost:8080
  ./smoke-test.sh 8090       # custom port
  ```

> ⚠️ **Use `http://`, not `https://`.** The app speaks plain HTTP. Opening
> `https://localhost:8080/...` produces a blank page and a Tomcat
> *"Invalid character found in method name"* log line.

---

## Workshop steps / Kroky workshopu

Full guide with goals, tasks, hints and "done when…" checks: [**STEPS.md**](STEPS.md).
Odkazy ke čtení k tématům / further-reading links: [**RESOURCES.md**](RESOURCES.md).

Request flow: **Controller → Service → Repository → SQLite** (see STEPS.md).

| Step | Topic | What you build |
|------|-------|----------------|
| 1 | SQLite setup & schema | `expenses.db` file on disk |
| 2 | Repository: INSERT & SELECT | `ExpenseRepository` with `JdbcTemplate` |
| 3 | Repository: DELETE & findById | Complete CRUD repository |
| 4 | Service → Repository | **Data survives a restart!** |
| 5 | OpenAPI / Swagger (+ live demo) | Production-ready Swagger docs |
| 6 *(bonus)* | Error handling | Consistent JSON error responses (404/500) |

### Key moments / Klíčové momenty

| Step | What happens |
|------|--------------|
| 4 | **Data survives a restart!** HashMap replaced by SQLite — Controller unchanged. |
| 5 | Swagger UI with descriptions + examples; live POST/GET demo through the whole stack. |
| 6 *(bonus)* | Missing id → consistent 404 JSON instead of the default error page. |

---

## Prerequisites / Předpoklady

- Completed **Session 1** ([expense-tracker-workshop-01](https://github.com/UnityInFlow/expense-tracker-workshop-01))
  or Spring Boot basics
- IntelliJ IDEA Community + JDK 21
- `sqlite3` CLI (`brew install sqlite3` / `apt install sqlite3`)

Detailed install guide: [SETUP.md](SETUP.md).

---

## Tools / Nástroje

| Tool | Usage |
|------|-------|
| IntelliJ IDEA Community | All steps |
| JDK 21 | Compilation and execution |
| sqlite3 CLI | Verifying data in the database |
| Swagger UI | Testing the API in the browser |

---

## Related / Souvislosti

**Session 1 — Kotlin & Spring Boot Basics**
<https://github.com/UnityInFlow/expense-tracker-workshop-01>

**Next steps after the workshop:**
- W01 Kotlin Idioms — idiomatic Kotlin for backend
- W02 Spring Boot Basics — advanced Spring Boot patterns
