package dev.workshop.expense

// ═══ STEP 5 — Request validation @Valid ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-05-final/)

// TODO (5.1): Add the import for the three constraint annotations
//   Hint: import jakarta.validation.constraints.Min
//         import jakarta.validation.constraints.NotBlank
//         import jakarta.validation.constraints.Size

// TODO (5.2): Annotate `description` with @field:NotBlank and @field:Size
//   Hint: @field:NotBlank(message = "Popis nesmi byt prazdny")
//         @field:Size(min = 2, max = 100)
//   NOTE: In a Kotlin data class use the @field: prefix so the annotation targets the backing field

// TODO (5.3): Annotate `amount` with @field:Min
//   Hint: @field:Min(value = 1, message = "Castka musi byt alespon 1 Kc")
data class CreateExpenseRequest(
    val description: String,
    val amount: Int
)
