# Step 6 — Error handling

## What we already have
- Steps 1-4: SQLite + Repository + Service
- Step 5: Request validation

## What we will do
Centralized error handling — all errors in the same JSON format.
@RestControllerAdvice = global exception interceptor.

## Tasks
1. Create GlobalExceptionHandler.kt (see TODO file)
2. Create ExpenseNotFoundException.kt
3. Update findById in Controller to throw an exception instead of ResponseEntity
4. Test via Swagger UI
