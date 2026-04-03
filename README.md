# Step 4 — Service → Repository (solution)

## KEY MOMENT: Data survives a restart!

1. Add an expense via Swagger UI
2. Restart the application (Ctrl+C, ./mvnw spring-boot:run)
3. GET /expenses → data is still there!

## What we did
- ExpenseService now uses ExpenseRepository instead of HashMap
- Constructor injection — Spring injects the repository automatically
- The Controller did NOT change a single line — the architecture from Session 1 works

## Next step
Open `step-05-start/` for request validation.
