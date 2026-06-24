package dev.workshop.expense

// ═══ STEP 4 — Service → Repository ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-04-final/)

import org.springframework.stereotype.Service

@Service
class ExpenseService {
    // TODO: Change to constructor injection with ExpenseRepository:
    //       class ExpenseService(private val repository: ExpenseRepository)
    //       And rewrite all methods to use repository instead of database

    private val database = HashMap<Int, Expense>()
    private var nextId = 1

    fun add(description: String, amount: Int): Expense {
        // TODO: Rewrite to repository.save(description, amount, "2024-01-15")
        val expense = Expense(nextId, description, amount, "2024-01-15")
        database[nextId] = expense
        nextId++
        return expense
    }

    fun getAll(): List<Expense> = database.values.toList()
    // TODO: Rewrite to repository.findAll()

    fun findById(id: Int): Expense? = database[id]
    // TODO: Rewrite to repository.findById(id)

    fun delete(id: Int): Boolean = database.remove(id) != null
    // TODO: Rewrite to repository.delete(id)

    fun total(): Int = database.values.sumOf { it.amount }
    // TODO: Rewrite to repository.findAll().sumOf { it.amount }
}
