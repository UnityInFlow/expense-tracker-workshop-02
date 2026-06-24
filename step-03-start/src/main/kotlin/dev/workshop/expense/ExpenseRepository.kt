package dev.workshop.expense

// ═══ STEP 3 — Repository DELETE/findById ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-03-final/)

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.sql.Statement

@Repository
class ExpenseRepository(private val jdbc: JdbcTemplate) {

    // INSERT with auto-generated ID
    fun save(description: String, amount: Int, date: String): Expense {
        val sql = "INSERT INTO expenses (description, amount, date) VALUES (?, ?, ?)"
        val keyHolder = GeneratedKeyHolder()
        jdbc.update({ connection ->
            val ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            ps.setString(1, description)
            ps.setInt(2, amount)
            ps.setString(3, date)
            ps
        }, keyHolder)
        val id = keyHolder.key!!.toInt()
        return Expense(id, description, amount, date)
    }

    // SELECT all rows — lambda is called for each row
    fun findAll(): List<Expense> {
        return jdbc.query("SELECT * FROM expenses ORDER BY id") { rs, _ ->
            Expense(
                id = rs.getInt("id"),
                description = rs.getString("description"),
                amount = rs.getInt("amount"),
                date = rs.getString("date")
            )
        }
    }

    // TODO: Implement findById(id: Int): Expense?
    //       Use jdbc.queryForObject()
    //       NOTE: queryForObject throws EmptyResultDataAccessException when nothing is found
    //       Catch it and return null
    //       Hint:
    //       return try {
    //           jdbc.queryForObject("SELECT * FROM expenses WHERE id = ?",
    //               { rs, _ -> Expense(...) }, id)
    //       } catch (e: EmptyResultDataAccessException) { null }

    // TODO: Implement delete(id: Int): Boolean
    //       Use jdbc.update() — returns number of deleted rows
    //       Hint: return jdbc.update("DELETE FROM expenses WHERE id = ?", id) > 0
}
