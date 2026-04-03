package dev.workshop.expense

class ExpenseNotFoundException(id: Int) : RuntimeException("Vydaj s ID $id nebyl nalezen")
