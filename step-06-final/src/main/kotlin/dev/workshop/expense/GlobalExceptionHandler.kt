package dev.workshop.expense

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// Konzistentni chybova odpoved
data class ErrorResponse(
    val status: Int,
    val error: String,
    val message: String
)

// @RestControllerAdvice = globalny zachytavac vyjimek pro vsechny controllery
@RestControllerAdvice
class GlobalExceptionHandler {

    // Validacni chyby — @Valid selze
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val message = ex.bindingResult.fieldErrors
            .joinToString(", ") { "${it.field}: ${it.defaultMessage}" }
        return ResponseEntity.badRequest().body(
            ErrorResponse(400, "Validation Error", message)
        )
    }

    // Vydaj nenalezen
    @ExceptionHandler(ExpenseNotFoundException::class)
    fun handleNotFound(ex: ExpenseNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(404, "Not Found", ex.message ?: "Vydaj nenalezen")
        )
    }

    // Neocekavane chyby
    @ExceptionHandler(Exception::class)
    fun handleGeneral(ex: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity.internalServerError().body(
            ErrorResponse(500, "Internal Server Error", "Nastala neocekavana chyba")
        )
    }
}
