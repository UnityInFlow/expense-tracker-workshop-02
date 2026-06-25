package dev.workshop.expense

// ═══ STEP 7 — OpenAPI @Schema/@ApiResponse ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-07-final/)

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

// TODO (7.1): Import the Schema annotation
//   Hint: import io.swagger.v3.oas.annotations.media.Schema

// TODO (7.2): Annotate the data class itself with @Schema to describe the request body
//   Hint: @Schema(description = "Request for creating a new expense")

// TODO (7.3): Annotate `description` with @Schema (place it above the @field:NotBlank line)
//   Hint: @Schema(description = "Expense description", example = "Lunch at restaurant")

// TODO (7.4): Annotate `amount` with @Schema (place it above the @field:Min line)
//   Hint: @Schema(description = "Amount in CZK", example = "150")
data class CreateExpenseRequest(
    @field:NotBlank(message = "Description must not be empty")
    @field:Size(min = 2, max = 100, message = "Description must be 2-100 characters")
    val description: String,

    @field:Min(value = 1, message = "Amount must be at least 1 CZK")
    val amount: Int
)
