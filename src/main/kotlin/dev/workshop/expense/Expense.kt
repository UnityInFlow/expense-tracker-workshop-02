package dev.workshop.expense

data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)
