package dev.workshop.expense

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

// The Controller is the entry point of the API — it maps HTTP requests to methods
// and delegates down the chain. Request flow:
//     HTTP  ->  ExpenseController  ->  ExpenseService  ->  ExpenseRepository  ->  SQLite
@Tag(name = "Expense Tracker", description = "Expense management API")
@RestController
@RequestMapping("/expenses")
class ExpenseController(private val service: ExpenseService) {

    // STEP 5 — OpenAPI: add @ApiResponse(s) to each endpoint to document status codes (see STEPS.md).
    @Operation(summary = "Returns list of all expenses")
    @GetMapping
    fun getAll(): List<Expense> = service.getAll()

    @Operation(summary = "Adds a new expense")
    @PostMapping
    fun add(@RequestBody request: CreateExpenseRequest): Expense =
        service.add(request.description, request.amount)

    @Operation(summary = "Deletes expense by ID")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): Map<String, Any> =
        mapOf("success" to service.delete(id))

    @Operation(summary = "Returns total sum of all expenses")
    @GetMapping("/total")
    fun getTotal(): Map<String, Int> = mapOf("total" to service.total())

    // STEP 6 (BONUS) — Error handling: replace the manual 404 with an exception handled globally.
    // TODO (step 6, bonus): when the expense is missing, throw ExpenseNotFoundException(id) instead of
    //   returning ResponseEntity.notFound(). The return type then becomes plain Expense.
    @Operation(summary = "Finds expense by ID")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<Expense> {
        val expense = service.findById(id)
        return if (expense != null) ResponseEntity.ok(expense)
               else ResponseEntity.notFound().build()
    }
}
