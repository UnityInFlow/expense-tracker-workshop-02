# Step 2 — Repository: INSERT and SELECT (solution)

## What we did
- @Repository = Spring manages this class
- JdbcTemplate = Spring wrapper over JDBC, reduces 20 lines to 3
- GeneratedKeyHolder = retrieving the auto-generated ID after INSERT
- query() with lambda = mapping database rows to Kotlin objects
- rs = ResultSet — one row from the database

## Next step
Open `step-03-start/` for Repository: DELETE and findById.
