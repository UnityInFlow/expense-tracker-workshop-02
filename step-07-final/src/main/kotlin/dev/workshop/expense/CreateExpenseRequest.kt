package dev.workshop.expense

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(description = "Request for creating a new expense")
data class CreateExpenseRequest(
    @Schema(description = "Expense description", example = "Lunch at restaurant")
    @field:NotBlank(message = "Description must not be empty")
    @field:Size(min = 2, max = 100, message = "Description must be 2-100 characters")
    val description: String,

    @Schema(description = "Amount in CZK", example = "150")
    @field:Min(value = 1, message = "Amount must be at least 1 CZK")
    val amount: Int
)
