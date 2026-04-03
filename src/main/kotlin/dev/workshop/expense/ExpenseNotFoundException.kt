package dev.workshop.expense

class ExpenseNotFoundException(id: Int) : RuntimeException("Expense with ID $id not found")
