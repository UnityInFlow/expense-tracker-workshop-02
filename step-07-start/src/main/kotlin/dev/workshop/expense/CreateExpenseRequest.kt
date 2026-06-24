package dev.workshop.expense

// ═══ STEP 7 — OpenAPI @Schema/@ApiResponse ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-07-final/)

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

// TODO (7.1): Import the Schema annotation
//   Hint: import io.swagger.v3.oas.annotations.media.Schema

// TODO (7.2): Annotate the data class itself with @Schema to describe the request body
//   Hint: @Schema(description = "Pozadavek na vytvoreni vydaje")

// TODO (7.3): Annotate `description` with @Schema (place it above the @field:NotBlank line)
//   Hint: @Schema(description = "Popis vydaje", example = "Obed v restauraci")

// TODO (7.4): Annotate `amount` with @Schema (place it above the @field:Min line)
//   Hint: @Schema(description = "Castka v Kc", example = "150")
data class CreateExpenseRequest(
    @field:NotBlank(message = "Popis nesmi byt prazdny")
    @field:Size(min = 2, max = 100)
    val description: String,

    @field:Min(value = 1, message = "Castka musi byt alespon 1 Kc")
    val amount: Int
)
