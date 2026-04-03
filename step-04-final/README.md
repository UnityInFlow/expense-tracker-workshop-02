# Step 4 — Service → Repository (reseni)

## KLICOVY MOMENT: Data preziji restart!

1. Pridejte vydaj pres Swagger UI
2. Restartujte aplikaci (Ctrl+C, ./mvnw spring-boot:run)
3. GET /expenses → data jsou stale tam!

## Co jsme udelali
- ExpenseService nyni pouziva ExpenseRepository misto HashMap
- Constructor injection — Spring vlozi repository automaticky
- Controller se NEZMENIL ani radek — architektura ze Session 1 funguje

## Dalsi krok
Otevri `step-05-start/` pro Validaci requestu.
