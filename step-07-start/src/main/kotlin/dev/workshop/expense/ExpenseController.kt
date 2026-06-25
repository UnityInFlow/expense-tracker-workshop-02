package dev.workshop.expense

// ═══ STEP 7 — OpenAPI @Schema/@ApiResponse ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-07-final/)

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

// TODO (7.8): Import the ApiResponse and ApiResponses annotations
//   Hint: import io.swagger.v3.oas.annotations.responses.ApiResponse
//         import io.swagger.v3.oas.annotations.responses.ApiResponses

@Tag(name = "Expense Tracker", description = "Expense management API")
@RestController
@RequestMapping("/expenses")
class ExpenseController(private val service: ExpenseService) {

    @Operation(summary = "Returns list of all expenses")
    // TODO (7.9): Add a single @ApiResponse documenting the 200 response
    //   Hint: @ApiResponse(responseCode = "200", description = "List of expenses")
    @GetMapping
    fun getAll(): List<Expense> = service.getAll()

    @Operation(summary = "Adds a new expense")
    // TODO (7.10): Add @ApiResponses with two entries: 200 (created) and 400 (validation failed)
    //   Hint: @ApiResponses(
    //             ApiResponse(responseCode = "200", description = "Expense added successfully"),
    //             ApiResponse(responseCode = "400", description = "Invalid request — validation failed")
    //         )
    @PostMapping
    fun add(@Valid @RequestBody request: CreateExpenseRequest): Expense =
        service.add(request.description, request.amount)

    @Operation(summary = "Deletes expense by ID")
    // TODO (7.11): Add @ApiResponses documenting 200 (deleted) and 200 (not found, success: false)
    //   Hint: @ApiResponses(
    //             ApiResponse(responseCode = "200", description = "Expense deleted"),
    //             ApiResponse(responseCode = "200", description = "Expense not found — success: false")
    //         )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): Map<String, Any> =
        mapOf("success" to service.delete(id))

    @Operation(summary = "Returns total sum of all expenses")
    // TODO (7.12): Add a single @ApiResponse documenting the 200 response
    //   Hint: @ApiResponse(responseCode = "200", description = "Total sum")
    @GetMapping("/total")
    fun getTotal(): Map<String, Int> = mapOf("total" to service.total())

    @Operation(summary = "Finds expense by ID")
    // TODO (7.13): Add @ApiResponses with two entries: 200 (found) and 404 (not found)
    //   Hint: @ApiResponses(
    //             ApiResponse(responseCode = "200", description = "Expense found"),
    //             ApiResponse(responseCode = "404", description = "Expense not found")
    //         )
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Expense {
        return service.findById(id)
            ?: throw ExpenseNotFoundException(id)
    }
}
