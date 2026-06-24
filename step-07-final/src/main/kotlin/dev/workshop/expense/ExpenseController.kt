package dev.workshop.expense

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@Tag(name = "Expense Tracker", description = "API pro spravu vydaju")
@RestController
@RequestMapping("/expenses")
class ExpenseController(private val service: ExpenseService) {

    @Operation(summary = "Vrati seznam vsech vydaju")
    @ApiResponse(responseCode = "200", description = "Seznam vydaju")
    @GetMapping
    fun getAll(): List<Expense> = service.getAll()

    @Operation(summary = "Prida novy vydaj")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Vydaj uspesne pridan"),
        ApiResponse(responseCode = "400", description = "Nevalidni pozadavek — validace selhala")
    )
    @PostMapping
    fun add(@Valid @RequestBody request: CreateExpenseRequest): Expense =
        service.add(request.description, request.amount)

    @Operation(summary = "Smaze vydaj podle ID")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Vydaj smazan"),
        ApiResponse(responseCode = "200", description = "Vydaj nenalezen — success: false")
    )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): Map<String, Any> =
        mapOf("success" to service.delete(id))

    @Operation(summary = "Vrati celkovou sumu vydaju")
    @ApiResponse(responseCode = "200", description = "Celkova suma")
    @GetMapping("/total")
    fun getTotal(): Map<String, Int> = mapOf("total" to service.total())

    @Operation(summary = "Najde vydaj podle ID")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Vydaj nalezen"),
        ApiResponse(responseCode = "404", description = "Vydaj nenalezen")
    )
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Expense {
        return service.findById(id)
            ?: throw ExpenseNotFoundException(id)
    }
}
