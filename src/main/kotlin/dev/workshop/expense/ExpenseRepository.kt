package dev.workshop.expense

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.sql.Statement

@Repository
class ExpenseRepository(private val jdbc: JdbcTemplate) {

    // INSERT s auto-generovanym ID
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
        // keyHolder.key!! = auto-generovane ID z databaze
        val id = keyHolder.key!!.toInt()
        return Expense(id, description, amount, date)
    }

    // SELECT vsech radku — lambda se zavola pro kazdy radek
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
}
