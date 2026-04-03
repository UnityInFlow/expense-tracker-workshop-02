package dev.workshop.expense

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

// @field: prefix = annotation belongs to the property, not to the constructor
data class CreateExpenseRequest(
    @field:NotBlank(message = "Description must not be empty")
    @field:Size(min = 2, max = 100, message = "Description must be 2-100 characters")
    val description: String,

    @field:Min(value = 1, message = "Amount must be at least 1 CZK")
    val amount: Int
)
