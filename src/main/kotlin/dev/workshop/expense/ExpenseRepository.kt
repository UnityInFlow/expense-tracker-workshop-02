package dev.workshop.expense

// STEP 2 — Repository save() + findAll(): the data-access layer over SQLite, using JdbcTemplate.
// STEP 3 — Repository findById() + delete(): finish the CRUD set.
//
// This file is intentionally an empty shell so the Session-1 (in-memory) app still compiles.
// You will fill it in once SQLite is wired up in STEP 1. Stuck? See the `final` branch.
//
// TODO (step 2): create the class and inject JdbcTemplate, then implement save() + findAll():
//
//   import org.springframework.jdbc.core.JdbcTemplate
//   import org.springframework.jdbc.support.GeneratedKeyHolder
//   import org.springframework.stereotype.Repository
//   import java.sql.Statement
//
//   @Repository
//   class ExpenseRepository(private val jdbc: JdbcTemplate) {
//       fun save(description: String, amount: Int, date: String): Expense { /* INSERT, return new row */ }
//       fun findAll(): List<Expense> { /* SELECT * FROM expenses ORDER BY id */ }
//
// TODO (step 3): add findById() and delete():
//       fun findById(id: Int): Expense? { /* queryForObject; catch EmptyResultDataAccessException -> null */ }
//       fun delete(id: Int): Boolean    { /* DELETE ...; return updated rows > 0 */ }
//   }
