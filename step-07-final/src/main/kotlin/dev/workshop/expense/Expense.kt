package dev.workshop.expense

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Vydaj v systemu")
data class Expense(
    @Schema(description = "Unikatni ID vydaje", example = "1")
    val id: Int,
    @Schema(description = "Popis vydaje", example = "Obed v restauraci")
    val description: String,
    @Schema(description = "Castka v Kc", example = "150")
    val amount: Int,
    @Schema(description = "Datum vydaje YYYY-MM-DD", example = "2024-01-15")
    val date: String
)
