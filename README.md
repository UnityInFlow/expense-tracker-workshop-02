# Step 6 — Error handling

## Co uz mame
- Step 1-4: SQLite + Repository + Service
- Step 5: Validace requestu

## Co budeme delat
Centralni error handling — vsechny chyby ve stejnem JSON formatu.
@RestControllerAdvice = globalny zachytavac vyjimek.

## Ukoly
1. Vytvor GlobalExceptionHandler.kt (viz TODO soubor)
2. Vytvor ExpenseNotFoundException.kt
3. Uprav findById v Controller aby hazela vyjimku misto ResponseEntity
4. Otestuj pres Swagger UI
