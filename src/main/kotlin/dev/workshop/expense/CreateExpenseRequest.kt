package dev.workshop.expense

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(description = "Request pro vytvoreni noveho vydaje")
data class CreateExpenseRequest(
    @Schema(description = "Popis vydaje", example = "Obed v restauraci")
    @field:NotBlank(message = "Popis nesmi byt prazdny")
    @field:Size(min = 2, max = 100, message = "Popis musi mit 2-100 znaku")
    val description: String,

    @Schema(description = "Castka v Kc", example = "150")
    @field:Min(value = 1, message = "Castka musi byt alespon 1 Kc")
    val amount: Int
)
