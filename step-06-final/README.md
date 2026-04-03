# Step 6 — Error handling (reseni)

## Co jsme udelali
- ErrorResponse = konzistentni JSON format pro vsechny chyby
- @RestControllerAdvice = jeden handler pro vsechny controllery
- @ExceptionHandler = metoda ktera zachyti konkretni vyjimku
- ExpenseNotFoundException = vlastni vyjimka s jasnou zpravou
- Elvis operator ?: v controlleru — pokud null, throw vyjimku

## Testovani
- GET /expenses/999 → 404 Not Found s JSON ErrorResponse
- POST /expenses prazdny description → 400 Validation Error
- Obe chyby maji stejny format

## Dalsi krok
Otevri `step-07-start/` pro OpenAPI finalizaci.
