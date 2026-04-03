package dev.workshop.expense

// TODO: Add @Schema annotations to each field:
//   @Schema(description = "Unique expense ID", example = "1")
//   @Schema(description = "Expense description", example = "Lunch at restaurant")
//   @Schema(description = "Amount in CZK", example = "150")
//   @Schema(description = "Expense date YYYY-MM-DD", example = "2024-01-15")
// Import: import io.swagger.v3.oas.annotations.media.Schema
data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)
