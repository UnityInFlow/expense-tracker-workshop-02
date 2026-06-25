package dev.workshop.expense

// ═══ STEP 6 — Error handling @RestControllerAdvice ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-06-final/)

// TODO (6.3): Add the necessary imports
//   Hint: import org.springframework.http.HttpStatus
//         import org.springframework.http.ResponseEntity
//         import org.springframework.web.bind.MethodArgumentNotValidException
//         import org.springframework.web.bind.annotation.ExceptionHandler
//         import org.springframework.web.bind.annotation.RestControllerAdvice

// TODO (6.4): Define the ErrorResponse data class with three fields: status, error, message
//   Hint: data class ErrorResponse(val status: Int, val error: String, val message: String)

// TODO (6.5): Create the GlobalExceptionHandler class annotated with @RestControllerAdvice
//   Hint: @RestControllerAdvice
//         class GlobalExceptionHandler {
//             ...
//         }

// TODO (6.6): Inside GlobalExceptionHandler, add a handler for @Valid failures (400 Bad Request)
//   Hint: @ExceptionHandler(MethodArgumentNotValidException::class)
//         fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
//             val message = ex.bindingResult.fieldErrors
//                 .joinToString(", ") { "${it.field}: ${it.defaultMessage}" }
//             return ResponseEntity.badRequest().body(ErrorResponse(400, "Validation Error", message))
//         }

// TODO (6.7): Add a handler for ExpenseNotFoundException (404 Not Found)
//   Hint: @ExceptionHandler(ExpenseNotFoundException::class)
//         fun handleNotFound(ex: ExpenseNotFoundException): ResponseEntity<ErrorResponse> {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                 .body(ErrorResponse(404, "Not Found", ex.message ?: "Vydaj nenalezen"))
//         }

// TODO (6.8): Add a catch-all handler for any other Exception (500 Internal Server Error)
//   Hint: @ExceptionHandler(Exception::class)
//         fun handleGeneral(ex: Exception): ResponseEntity<ErrorResponse> {
//             return ResponseEntity.internalServerError()
//                 .body(ErrorResponse(500, "Internal Server Error", "Nastala neocekavana chyba"))
//         }
