package dev.workshop.expense

import org.springframework.stereotype.Service

// Constructor injection — Spring automaticky vlozi repository
@Service
class ExpenseService(private val repository: ExpenseRepository) {

    fun add(description: String, amount: Int): Expense =
        repository.save(description, amount, "2024-01-15")

    fun getAll(): List<Expense> = repository.findAll()

    fun findById(id: Int): Expense? = repository.findById(id)

    fun delete(id: Int): Boolean = repository.delete(id)

    fun total(): Int = repository.findAll().sumOf { it.amount }
}
// Controller se NEZMENIL ani radek!
