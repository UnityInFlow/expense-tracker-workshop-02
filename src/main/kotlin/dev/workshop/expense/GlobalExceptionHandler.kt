package dev.workshop.expense

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// STEP 6 — Error handling: a consistent error body returned for every handled exception.
data class ErrorResponse(
    val status: Int,
    val error: String,
    val message: String
)

// STEP 6 — Error handling: @RestControllerAdvice = global exception interceptor for all controllers.
@RestControllerAdvice
class GlobalExceptionHandler {

    // Validation errors — @Valid fails → 400
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val message = ex.bindingResult.fieldErrors
            .joinToString(", ") { "${it.field}: ${it.defaultMessage}" }
        return ResponseEntity.badRequest().body(
            ErrorResponse(400, "Validation Error", message)
        )
    }

    // Expense not found → 404
    @ExceptionHandler(ExpenseNotFoundException::class)
    fun handleNotFound(ex: ExpenseNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(404, "Not Found", ex.message ?: "Expense not found")
        )
    }

    // Unexpected errors → 500
    @ExceptionHandler(Exception::class)
    fun handleGeneral(ex: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity.internalServerError().body(
            ErrorResponse(500, "Internal Server Error", "An unexpected error occurred")
        )
    }
}
