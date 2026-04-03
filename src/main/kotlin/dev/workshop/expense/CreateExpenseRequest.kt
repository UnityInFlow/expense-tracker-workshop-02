package dev.workshop.expense

// TODO: Add validation annotations:
//   @field:NotBlank(message = "Description must not be empty")
//   @field:Size(min = 2, max = 100, message = "Description must be 2-100 characters")
//   on description
//
//   @field:Min(value = 1, message = "Amount must be at least 1 CZK")
//   on amount
//
// NOTE: In Kotlin data class use the @field: prefix!
// Import: import jakarta.validation.constraints.*
data class CreateExpenseRequest(
    val description: String,
    val amount: Int
)
