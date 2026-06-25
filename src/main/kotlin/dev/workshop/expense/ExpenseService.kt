package dev.workshop.expense

import org.springframework.stereotype.Service

// STEP 4 — Service → Repository: swap the in-memory HashMap for the database-backed repository.
// TODO (step 4): once ExpenseRepository is implemented (steps 2–3), inject it via the constructor
//   (class ExpenseService(private val repository: ExpenseRepository)) and delegate every method
//   to it instead of the HashMap below. The Controller will NOT change — that is the whole point.
@Service
class ExpenseService {
    private val database = HashMap<Int, Expense>()
    private var nextId = 1

    fun add(description: String, amount: Int): Expense {
        val expense = Expense(nextId, description, amount, "2024-01-15")
        database[nextId] = expense
        nextId++
        return expense
    }

    fun getAll(): List<Expense> = database.values.toList()
    fun findById(id: Int): Expense? = database[id]
    fun delete(id: Int): Boolean = database.remove(id) != null
    fun total(): Int = database.values.sumOf { it.amount }
}
