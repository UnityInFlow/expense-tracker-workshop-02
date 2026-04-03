# Step 5 — Request validation @Valid

## What we already have
- Steps 1-4: SQLite + Repository + Service connection

## What we will do
Add request validation — @Valid, @NotBlank, @Min.
Bad requests will get 400 Bad Request instead of 500.

## Tasks
1. Add the validation dependency to pom.xml (see TODO)
2. Add annotations to CreateExpenseRequest.kt (see TODO)
3. Add @Valid to ExpenseController.kt (see TODO)
4. Test via Swagger UI: send an empty description or a negative amount
