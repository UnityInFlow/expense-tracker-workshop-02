# Step 7 — OpenAPI finalization (solution)

## FINAL STATE OF SESSION 2

## What we added in Session 2
- ExpenseRepository.kt — SQL queries, separated from business logic
- GlobalExceptionHandler.kt — consistent error responses
- ExpenseNotFoundException.kt — custom exception
- schema.sql — CREATE TABLE
- @Valid + @NotBlank/@Min — request validation
- @Schema + @ApiResponse — production-ready Swagger

## What did NOT change
- Expense.kt — data model (only @Schema annotations added)
- ExpenseController.kt — HTTP layer unchanged (except @Valid and throw)

## Next steps
- W01 Kotlin Idioms — idiomatic Kotlin
- W02 Spring Boot Basics — advanced Spring Boot
