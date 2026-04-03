# Step 5 — Validace requestu @Valid

## Co uz mame
- Step 1-4: SQLite + Repository + Service propojeni

## Co budeme delat
Pridame validaci requestu — @Valid, @NotBlank, @Min.
Spatne requesty dostanou 400 Bad Request misto 500.

## Ukoly
1. Pridej validacni zavislost do pom.xml (viz TODO)
2. Pridej anotace do CreateExpenseRequest.kt (viz TODO)
3. Pridej @Valid do ExpenseController.kt (viz TODO)
4. Otestuj pres Swagger UI: posli prazdny description nebo zaporne amount
