# Step 4 — Service → Repository propojeni

## Co uz mame
- Step 1-3: SQLite + Repository (save, findAll, findById, delete)

## Co budeme delat
Prepojime ExpenseService s ExpenseRepository — vyhodime HashMap a pouzijeme databazi.

## Ukoly
Otevri ExpenseService.kt a:
1. Pridej constructor parameter: `private val repository: ExpenseRepository`
2. Prepis metody aby pouzivaly repository misto database (viz TODO komentare)
3. Spust aplikaci, pridej vydaj, restartuj — data zu stale!
