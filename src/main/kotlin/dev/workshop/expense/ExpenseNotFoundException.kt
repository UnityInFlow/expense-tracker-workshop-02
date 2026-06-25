package dev.workshop.expense

// STEP 6 (BONUS) — Error handling: thrown by the controller when an expense is missing; mapped to 404.
class ExpenseNotFoundException(id: Int) : RuntimeException("Expense with ID $id not found")
