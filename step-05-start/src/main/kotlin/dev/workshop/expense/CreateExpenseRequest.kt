package dev.workshop.expense

// ═══ STEP 5 — Request validation @Valid ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-05-final/)

// TODO (5.1): Add the import for the three constraint annotations
//   Hint: import jakarta.validation.constraints.Min
//         import jakarta.validation.constraints.NotBlank
//         import jakarta.validation.constraints.Size

// TODO (5.2): Annotate `description` with @field:NotBlank and @field:Size
//   Hint: @field:NotBlank(message = "Description must not be empty")
//         @field:Size(min = 2, max = 100, message = "Description must be 2-100 characters")
//   NOTE: In a Kotlin data class use the @field: prefix so the annotation targets the backing field

// TODO (5.3): Annotate `amount` with @field:Min
//   Hint: @field:Min(value = 1, message = "Amount must be at least 1 CZK")
data class CreateExpenseRequest(
    val description: String,
    val amount: Int
)
