package dev.workshop.expense

// STEP 6 — Error handling: one @RestControllerAdvice that turns exceptions into a consistent
// JSON error body (status / error / message) for 400 (validation), 404 (not found), 500 (other).
//
// This file is intentionally empty so the Session-1 app still compiles. Fill it in during STEP 6.
//
// TODO (step 6): define ErrorResponse and the advice:
//   data class ErrorResponse(val status: Int, val error: String, val message: String)
//
//   @RestControllerAdvice
//   class GlobalExceptionHandler {
//       @ExceptionHandler(MethodArgumentNotValidException::class) -> 400
//       @ExceptionHandler(ExpenseNotFoundException::class)        -> 404
//       @ExceptionHandler(Exception::class)                       -> 500
//   }
