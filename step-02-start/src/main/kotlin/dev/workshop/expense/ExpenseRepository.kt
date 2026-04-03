package dev.workshop.expense

import org.springframework.stereotype.Repository
import org.springframework.jdbc.core.JdbcTemplate

@Repository
class ExpenseRepository(private val jdbc: JdbcTemplate) {

    // TODO: Implement the save(description, amount, date): Expense method
    //       Use jdbc.update() with GeneratedKeyHolder to retrieve the ID
    //       Hint:
    //       val sql = "INSERT INTO expenses (description, amount, date) VALUES (?, ?, ?)"
    //       val keyHolder = GeneratedKeyHolder()
    //       jdbc.update({ connection ->
    //           val ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
    //           ps.setString(1, description)
    //           ps.setInt(2, amount)
    //           ps.setString(3, date)
    //           ps
    //       }, keyHolder)
    //       return Expense(keyHolder.key!!.toInt(), description, amount, date)

    // TODO: Implement the findAll(): List<Expense> method
    //       Use jdbc.query() with a lambda for row mapping
    //       Hint:
    //       return jdbc.query("SELECT * FROM expenses ORDER BY id") { rs, _ ->
    //           Expense(rs.getInt("id"), rs.getString("description"),
    //                   rs.getInt("amount"), rs.getString("date"))
    //       }
}
