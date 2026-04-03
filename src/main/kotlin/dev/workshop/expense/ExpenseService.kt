package dev.workshop.expense

import org.springframework.stereotype.Service

@Service
class ExpenseService {
    // TODO: Zmenit na constructor injection s ExpenseRepository:
    //       class ExpenseService(private val repository: ExpenseRepository)
    //       A prepsat vsechny metody aby pouzivaly repository misto database

    private val database = HashMap<Int, Expense>()
    private var nextId = 1

    fun add(description: String, amount: Int): Expense {
        // TODO: Prepsat na repository.save(description, amount, "2024-01-15")
        val expense = Expense(nextId, description, amount, "2024-01-15")
        database[nextId] = expense
        nextId++
        return expense
    }

    fun getAll(): List<Expense> = database.values.toList()
    // TODO: Prepsat na repository.findAll()

    fun findById(id: Int): Expense? = database[id]
    // TODO: Prepsat na repository.findById(id)

    fun delete(id: Int): Boolean = database.remove(id) != null
    // TODO: Prepsat na repository.delete(id)

    fun total(): Int = database.values.sumOf { it.amount }
    // TODO: Prepsat na repository.findAll().sumOf { it.amount }
}
