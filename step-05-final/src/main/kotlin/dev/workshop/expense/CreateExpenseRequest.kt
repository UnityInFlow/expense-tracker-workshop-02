package dev.workshop.expense

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

// @field: prefix = annotation belongs to the property, not to the constructor
data class CreateExpenseRequest(
    @field:NotBlank(message = "Popis nesmi byt prazdny")
    @field:Size(min = 2, max = 100)
    val description: String,

    @field:Min(value = 1, message = "Castka musi byt alespon 1 Kc")
    val amount: Int
)
