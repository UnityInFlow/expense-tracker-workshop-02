# Step 4 — Service → Repository connection

## What we already have
- Steps 1-3: SQLite + Repository (save, findAll, findById, delete)

## What we will do
Connect ExpenseService to ExpenseRepository — remove the HashMap and use the database.

## Tasks
Open ExpenseService.kt and:
1. Add constructor parameter: `private val repository: ExpenseRepository`
2. Rewrite the methods to use repository instead of database (see TODO comments)
3. Run the application, add an expense, restart — data is still there!
