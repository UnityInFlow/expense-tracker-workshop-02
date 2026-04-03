# Step 1 — SQLite setup and schema (solution)

## What we did
- SQLite = database as a file on disk (expenses.db)
- No server, no port, no installation
- schema.sql runs automatically on startup (spring.sql.init.mode: always)
- IF NOT EXISTS = safe on restart

## Verification
```bash
ls -la expenses.db
sqlite3 expenses.db ".tables"     # → expenses
sqlite3 expenses.db "SELECT * FROM expenses;"
```

## Next step
Open `step-02-start/` for Repository: INSERT and SELECT.
