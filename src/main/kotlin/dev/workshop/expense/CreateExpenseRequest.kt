package dev.workshop.expense

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

// STEP 7 — OpenAPI: @Schema documents the request model.
@Schema(description = "Request for creating a new expense")
data class CreateExpenseRequest(
    // STEP 5 — Bean Validation: description must be non-blank and 2–100 chars.
    @Schema(description = "Expense description", example = "Lunch at restaurant")
    @field:NotBlank(message = "Description must not be empty")
    @field:Size(min = 2, max = 100, message = "Description must be 2-100 characters")
    val description: String,

    // STEP 5 — Bean Validation: amount must be at least 1.
    @Schema(description = "Amount in CZK", example = "150")
    @field:Min(value = 1, message = "Amount must be at least 1 CZK")
    val amount: Int
)
