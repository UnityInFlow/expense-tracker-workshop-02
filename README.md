# Step 3 — Repository: DELETE and findById (solution)

## What we did
- findById() uses queryForObject() — throws an exception when nothing is found
- EmptyResultDataAccessException = we catch it and return null
- delete() returns Boolean — true if something was deleted
- jdbc.update() returns the number of affected rows

## Next step
Open `step-04-start/` for Service → Repository connection.
