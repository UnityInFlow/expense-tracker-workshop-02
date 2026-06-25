package dev.workshop.expense

// ═══ STEP 6 — Error handling @RestControllerAdvice ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-06-final/)

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
    // TODO (6.2): Replace the if/else ResponseEntity pattern with an elvis throw
    //   Change the return type from ResponseEntity<Expense> to just Expense
    //   Hint: fun findById(@PathVariable id: Int): Expense {
    //             return service.findById(id) ?: throw ExpenseNotFoundException(id)
    //         }
    //   Remove the ResponseEntity import once done
    fun findById(@PathVariable id: Int): ResponseEntity<Expense> {
        val expense = service.findById(id)
        return if (expense != null) ResponseEntity.ok(expense)
               else ResponseEntity.notFound().build()
    }
}
