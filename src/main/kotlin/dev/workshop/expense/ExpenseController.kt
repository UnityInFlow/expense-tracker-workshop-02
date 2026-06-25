package dev.workshop.expense

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

// The Controller is the entry point of the API — it maps HTTP requests to methods
// and delegates down the chain. Request flow:
//     HTTP  ->  ExpenseController  ->  ExpenseService  ->  ExpenseRepository  ->  SQLite
@Tag(name = "Expense Tracker", description = "Expense management API")
@RestController
@RequestMapping("/expenses")
class ExpenseController(private val service: ExpenseService) {

    @Operation(summary = "Returns list of all expenses")
    // STEP 5 — OpenAPI: document the response codes.
    @ApiResponse(responseCode = "200", description = "List of expenses")
    @GetMapping
    fun getAll(): List<Expense> = service.getAll()

    @Operation(summary = "Adds a new expense")
    @ApiResponse(responseCode = "200", description = "Expense added successfully")
    @PostMapping
    fun add(@RequestBody request: CreateExpenseRequest): Expense =
        service.add(request.description, request.amount)

    @Operation(summary = "Deletes expense by ID")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Expense deleted"),
        ApiResponse(responseCode = "200", description = "Expense not found — success: false")
    )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): Map<String, Any> =
        mapOf("success" to service.delete(id))

    @Operation(summary = "Returns total sum of all expenses")
    @ApiResponse(responseCode = "200", description = "Total sum")
    @GetMapping("/total")
    fun getTotal(): Map<String, Int> = mapOf("total" to service.total())

    @Operation(summary = "Finds expense by ID")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Expense found"),
        ApiResponse(responseCode = "404", description = "Expense not found")
    )
    @GetMapping("/{id}")
    // STEP 6 (BONUS) — Error handling: throw instead of building a 404 by hand; GlobalExceptionHandler maps it.
    fun findById(@PathVariable id: Int): Expense {
        return service.findById(id)
            ?: throw ExpenseNotFoundException(id)
    }
}
