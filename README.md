# Step 7 — OpenAPI finalizace (reseni)

## FINALNI STAV SESSION 2

## Co jsme pridali v Session 2
- ExpenseRepository.kt — SQL dotazy, oddelene od logiky
- GlobalExceptionHandler.kt — konzistentni error responses
- ExpenseNotFoundException.kt — vlastni vyjimka
- schema.sql — CREATE TABLE
- @Valid + @NotBlank/@Min — validace requestu
- @Schema + @ApiResponse — production-ready Swagger

## Co se NEZMENILO
- Expense.kt — data model (jen pridane @Schema anotace)
- ExpenseController.kt — HTTP vrstva beze zmeny (az na @Valid a throw)

## Dalsi kroky
- W01 Kotlin Idioms — idiomaticky Kotlin
- W02 Spring Boot Basics — pokrocile Spring Boot
