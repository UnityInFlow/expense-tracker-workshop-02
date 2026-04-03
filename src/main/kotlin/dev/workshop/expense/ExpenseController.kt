package dev.workshop.expense

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Expense Tracker", description = "Expense management API")
@RestController
@RequestMapping("/expenses")
class ExpenseController(private val service: ExpenseService) {

    @Operation(summary = "Returns list of all expenses")
    @GetMapping
    fun getAll(): List<Expense> = service.getAll()

    @Operation(summary = "Adds a new expense")
    @PostMapping
    fun add(@Valid @RequestBody request: CreateExpenseRequest): Expense =
        service.add(request.description, request.amount)

    @Operation(summary = "Deletes expense by ID")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): Map<String, Any> =
        mapOf("success" to service.delete(id))

    @Operation(summary = "Returns total sum of all expenses")
    @GetMapping("/total")
    fun getTotal(): Map<String, Int> = mapOf("total" to service.total())

    @Operation(summary = "Finds expense by ID")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<Expense> {
        val expense = service.findById(id)
        return if (expense != null) ResponseEntity.ok(expense)
               else ResponseEntity.notFound().build()
    }
}
