package dev.workshop.expense

// STEP 5 — OpenAPI: document this request model.
// TODO (step 5): add @Schema(...) on the class and each field (see Expense.kt for the pattern).
data class CreateExpenseRequest(
    val description: String,
    val amount: Int
)
