package dev.workshop.expense

import io.swagger.v3.oas.annotations.media.Schema

// STEP 5 — OpenAPI: @Schema documents the model so Swagger shows descriptions and examples.
@Schema(description = "Expense in the system")
data class Expense(
    @Schema(description = "Unique expense ID", example = "1")
    val id: Int,
    @Schema(description = "Expense description", example = "Lunch at restaurant")
    val description: String,
    @Schema(description = "Amount in CZK", example = "150")
    val amount: Int,
    @Schema(description = "Expense date YYYY-MM-DD", example = "2024-01-15")
    val date: String
)
