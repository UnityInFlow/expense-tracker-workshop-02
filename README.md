# Expense Tracker Workshop — Session 2

## SQLite + Repository + Validation

A follow-up workshop to Session 1. Participants will add a SQLite database, a Repository layer, validation, and error handling. The Controller will not change a single line — validating the architecture from Session 1.

By the end of the workshop you will have a production-ready API where data survives a restart.

---

## Prerequisites

- Completed **Session 1** ([expense-tracker-workshop-01](https://github.com/UnityInFlow/expense-tracker-workshop-01)) or knowledge of Spring Boot basics
- IntelliJ IDEA Community + JDK 21
- sqlite3 CLI (`brew install sqlite3` / `apt install sqlite3`)

---

## Workshop structure

| Step | Topic | What we build |
|------|-------|--------------|
| Step 1 | SQLite setup and schema | `expenses.db` file on disk |
| Step 2 | Repository: INSERT and SELECT | `ExpenseRepository` with `JdbcTemplate` |
| Step 3 | Repository: DELETE and findById | Complete CRUD Repository |
| Step 4 | Service → Repository connection | Data survives a restart! |
| Step 5 | Request validation @Valid | API rejects invalid data |
| Step 6 | Error handling | Consistent error responses |
| Step 7 | OpenAPI finalization | Production-ready Swagger documentation |

Each step has:
- **start** — project with TODO comments (your tasks)
- **final** — complete solution with explanatory comments

---

## How to work with this repository

### Option A — Folders (recommended for beginners)

No git knowledge required. Just download and open folders.

**1. Download the repository:**

Click the green **Code** button → **Download ZIP** on this page.
Unzip the file.

**2. Getting started — Step 1:**

- Open IntelliJ IDEA
- File → Open → select the `step-01-start` folder
- Wait for dependencies to download
- Fill in the code where you see `// TODO:` comments
- Run: `./mvnw spring-boot:run`

**3. When you're done or stuck:**

Open the `step-01-final/` folder in IntelliJ — that's the complete solution.

**4. Continue to the next step:**

Close the project and open `step-02-start/`.

**Step-by-step flow:**
```
step-01-start/  →  fill in TODO  →  compare with  →  step-01-final/
step-02-start/  →  fill in TODO  →  compare with  →  step-02-final/
step-03-start/  →  fill in TODO  →  compare with  →  step-03-final/
step-04-start/  →  fill in TODO  →  compare with  →  step-04-final/
step-05-start/  →  fill in TODO  →  compare with  →  step-05-final/
step-06-start/  →  fill in TODO  →  compare with  →  step-06-final/
step-07-start/  →  fill in TODO  →  compare with  →  step-07-final/  ← FINAL STATE
```

**Tip — verifying data in the database:**
```bash
sqlite3 expenses.db ".tables"              # shows tables
sqlite3 expenses.db "SELECT * FROM expenses;"  # shows data
```

---

### Option B — Git branches (for advanced users)

Each step has its own branch. The branch contains ONLY the files for that step (at root level) — a complete Maven project.

**1. Clone the repository:**

```bash
git clone https://github.com/UnityInFlow/expense-tracker-workshop-02.git
cd expense-tracker-workshop-02
```

**2. Switch to the first step:**

```bash
git checkout step-01-start
```

You now see the complete Maven project at the root. Open it in IntelliJ.

**3. Work on the tasks:**

Edit the files directly — fill in the code where you see `// TODO:`.
Run: `./mvnw spring-boot:run`

**4. When you're done or stuck:**

```bash
git stash                     # saves your changes aside
git checkout step-01-final    # switches to the solution
```

**5. Continue to the next step:**

```bash
git checkout step-02-start    # next step
```

**All available branches:**
```
step-01-start    step-01-final
step-02-start    step-02-final
step-03-start    step-03-final
step-04-start    step-04-final    ← data survives a restart!
step-05-start    step-05-final
step-06-start    step-06-final
step-07-start    step-07-final    ← final state
```

**Tip — comparing your work with the solution:**
```bash
# On step-02-start after your work:
git diff step-02-final -- src/
```

**Tip — jumping to any step (when you fall behind):**
```bash
git checkout step-04-start    # skip to Step 4
# Continue from here — all previous steps are done
```

---

## Key moments

| Step | What happens |
|------|-------------|
| Step 4 final | **Data survives a restart!** HashMap replaced by SQLite. Controller did not change. |
| Step 5 final | API rejects empty descriptions and negative amounts — validation works. |
| Step 6 final | All errors in the same JSON format — consistent. |
| Step 7 final | Swagger UI with example values and error codes — production ready. |

---

## Tools

| Tool | Usage |
|------|-------|
| IntelliJ IDEA Community | All steps |
| JDK 21 | Compilation and execution |
| sqlite3 CLI | Verifying data in the database |
| Swagger UI | Testing the API in the browser |

Detailed installation guide: [SETUP.md](SETUP.md)

---

## Related

**Session 1 — Kotlin & Spring Boot Basics**
https://github.com/UnityInFlow/expense-tracker-workshop-01

**Next steps after the workshop:**
- W01 Kotlin Idioms — idiomatic Kotlin for backend
- W02 Spring Boot Basics — advanced Spring Boot patterns
