package dev.workshop.expense

import io.swagger.v3.oas.annotations.media.Schema

// STEP 5 — OpenAPI: @Schema documents the request model.
@Schema(description = "Request for creating a new expense")
data class CreateExpenseRequest(
    @Schema(description = "Expense description", example = "Lunch at restaurant")
    val description: String,
    @Schema(description = "Amount in CZK", example = "150")
    val amount: Int
)
