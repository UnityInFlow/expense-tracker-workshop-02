# Step 5 — Validace requestu @Valid (reseni)

## Co jsme udelali
- spring-boot-starter-validation = Jakarta Bean Validation
- @field: prefix = v Kotlin data class nutny pro spravne aplikovani anotaci
- @NotBlank = nesmi byt null ani prazdny retezec
- @Size = omezeni delky retezce
- @Min = minimalni hodnota cisla
- @Valid v controlleru = aktivuje validaci pro tento parametr

## Testovani
Posli pres Swagger UI:
- `{"description": "", "amount": 100}` → 400 Bad Request
- `{"description": "Test", "amount": 0}` → 400 Bad Request
- `{"description": "Test", "amount": 100}` → 201 Created

## Dalsi krok
Otevri `step-06-start/` pro Error handling.
