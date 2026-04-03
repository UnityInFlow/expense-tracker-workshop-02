# Step 6 — Error handling (solution)

## What we did
- ErrorResponse = consistent JSON format for all errors
- @RestControllerAdvice = one handler for all controllers
- @ExceptionHandler = method that catches a specific exception
- ExpenseNotFoundException = custom exception with a clear message
- Elvis operator ?: in controller — if null, throw exception

## Testing
- GET /expenses/999 → 404 Not Found with JSON ErrorResponse
- POST /expenses with empty description → 400 Validation Error
- Both errors have the same format

## Next step
Open `step-07-start/` for OpenAPI finalization.
