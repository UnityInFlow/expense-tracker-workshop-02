# Step 1 — SQLite setup a schema (reseni)

## Co jsme udelali
- SQLite = databaze jako soubor na disku (expenses.db)
- Zadny server, zadny port, zadna instalace
- schema.sql se spusti automaticky pri startu (spring.sql.init.mode: always)
- IF NOT EXISTS = bezpecne pri restartu

## Overeni
```bash
ls -la expenses.db
sqlite3 expenses.db ".tables"     # → expenses
sqlite3 expenses.db "SELECT * FROM expenses;"
```

## Dalsi krok
Otevri `step-02-start/` pro Repository: INSERT a SELECT.
