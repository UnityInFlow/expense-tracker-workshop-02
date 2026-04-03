package dev.workshop.expense

// TODO: Vytvorte GlobalExceptionHandler s anotaci @RestControllerAdvice
//
// 1. Vytvorte data class ErrorResponse(val status: Int, val error: String, val message: String)
//
// 2. Pridejte @ExceptionHandler(MethodArgumentNotValidException::class)
//    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse>
//    Hint: ex.bindingResult.fieldErrors.joinToString(", ") { "${it.field}: ${it.defaultMessage}" }
//
// 3. Pridejte @ExceptionHandler(ExpenseNotFoundException::class)
//    fun handleNotFound(ex: ExpenseNotFoundException): ResponseEntity<ErrorResponse>
//
// 4. Pridejte @ExceptionHandler(Exception::class)
//    fun handleGeneral(ex: Exception): ResponseEntity<ErrorResponse>
//    Pro neocekavane chyby — vrati 500
