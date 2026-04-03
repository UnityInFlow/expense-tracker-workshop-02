package dev.workshop.expense

// TODO: Pridejte @Schema anotace na kazdy field:
//   @Schema(description = "Unikatni ID vydaje", example = "1")
//   @Schema(description = "Popis vydaje", example = "Obed v restauraci")
//   @Schema(description = "Castka v Kc", example = "150")
//   @Schema(description = "Datum vydaje YYYY-MM-DD", example = "2024-01-15")
// Import: import io.swagger.v3.oas.annotations.media.Schema
data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)
