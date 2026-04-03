package dev.workshop.expense

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@Tag(name = "Expense Tracker", description = "Expense management API")
@RestController
@RequestMapping("/expenses")
class ExpenseController(private val service: ExpenseService) {

    @Operation(summary = "Returns list of all expenses")
    @ApiResponse(responseCode = "200", description = "List of expenses")
    @GetMapping
    fun getAll(): List<Expense> = service.getAll()

    @Operation(summary = "Adds a new expense")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Expense added successfully"),
        ApiResponse(responseCode = "400", description = "Invalid request — validation failed")
    )
    @PostMapping
    fun add(@Valid @RequestBody request: CreateExpenseRequest): Expense =
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
    fun findById(@PathVariable id: Int): Expense {
        return service.findById(id)
            ?: throw ExpenseNotFoundException(id)
    }
}
