package dev.workshop.expense

data class CreateExpenseRequest(
    val description: String,
    val amount: Int
)
