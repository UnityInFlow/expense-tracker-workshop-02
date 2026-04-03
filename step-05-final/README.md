# Step 5 — Request validation @Valid (solution)

## What we did
- spring-boot-starter-validation = Jakarta Bean Validation
- @field: prefix = required in Kotlin data class for correct annotation application
- @NotBlank = must not be null or empty string
- @Size = string length constraint
- @Min = minimum numeric value
- @Valid in controller = activates validation for this parameter

## Testing
Send via Swagger UI:
- `{"description": "", "amount": 100}` → 400 Bad Request
- `{"description": "Test", "amount": 0}` → 400 Bad Request
- `{"description": "Test", "amount": 100}` → 201 Created

## Next step
Open `step-06-start/` for error handling.
