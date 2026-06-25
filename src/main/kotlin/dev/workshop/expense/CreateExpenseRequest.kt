package dev.workshop.expense

// STEP 5 — Bean Validation: reject bad input before it reaches the service.
// TODO (step 5): add validation annotations on the fields. You will need:
//   import jakarta.validation.constraints.NotBlank
//   import jakarta.validation.constraints.Size
//   import jakarta.validation.constraints.Min
//   description -> @field:NotBlank + @field:Size(min = 2, max = 100, ...)
//   amount      -> @field:Min(value = 1, ...)
//
// STEP 7 — OpenAPI: document this request model.
// TODO (step 7): add @Schema(...) on the class and each field (see Expense.kt for the pattern).
data class CreateExpenseRequest(
    val description: String,
    val amount: Int
)
