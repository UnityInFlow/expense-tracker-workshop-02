package dev.workshop.expense

// TODO: Create GlobalExceptionHandler with the @RestControllerAdvice annotation
//
// 1. Create data class ErrorResponse(val status: Int, val error: String, val message: String)
//
// 2. Add @ExceptionHandler(MethodArgumentNotValidException::class)
//    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse>
//    Hint: ex.bindingResult.fieldErrors.joinToString(", ") { "${it.field}: ${it.defaultMessage}" }
//
// 3. Add @ExceptionHandler(ExpenseNotFoundException::class)
//    fun handleNotFound(ex: ExpenseNotFoundException): ResponseEntity<ErrorResponse>
//
// 4. Add @ExceptionHandler(Exception::class)
//    fun handleGeneral(ex: Exception): ResponseEntity<ErrorResponse>
//    For unexpected errors — returns 500
