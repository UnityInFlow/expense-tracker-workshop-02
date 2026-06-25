package dev.workshop.expense

// ═══ STEP 7 — OpenAPI @Schema/@ApiResponse ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-07-final/)

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

// TODO (7.8): Import the ApiResponse and ApiResponses annotations
//   Hint: import io.swagger.v3.oas.annotations.responses.ApiResponse
//         import io.swagger.v3.oas.annotations.responses.ApiResponses

@Tag(name = "Expense Tracker", description = "API pro spravu vydaju")
@RestController
@RequestMapping("/expenses")
class ExpenseController(private val service: ExpenseService) {

    @Operation(summary = "Vrati seznam vsech vydaju")
    // TODO (7.9): Add a single @ApiResponse documenting the 200 response
    //   Hint: @ApiResponse(responseCode = "200", description = "Seznam vydaju")
    @GetMapping
    fun getAll(): List<Expense> = service.getAll()

    @Operation(summary = "Prida novy vydaj")
    // TODO (7.10): Add @ApiResponses with two entries: 200 (created) and 400 (validation failed)
    //   Hint: @ApiResponses(
    //             ApiResponse(responseCode = "200", description = "Vydaj uspesne pridan"),
    //             ApiResponse(responseCode = "400", description = "Nevalidni pozadavek — validace selhala")
    //         )
    @PostMapping
    fun add(@Valid @RequestBody request: CreateExpenseRequest): Expense =
        service.add(request.description, request.amount)

    @Operation(summary = "Smaze vydaj podle ID")
    // TODO (7.11): Add @ApiResponses documenting 200 (deleted) and 200 (not found, success: false)
    //   Hint: @ApiResponses(
    //             ApiResponse(responseCode = "200", description = "Vydaj smazan"),
    //             ApiResponse(responseCode = "200", description = "Vydaj nenalezen — success: false")
    //         )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): Map<String, Any> =
        mapOf("success" to service.delete(id))

    @Operation(summary = "Vrati celkovou sumu vydaju")
    // TODO (7.12): Add a single @ApiResponse documenting the 200 response
    //   Hint: @ApiResponse(responseCode = "200", description = "Celkova suma")
    @GetMapping("/total")
    fun getTotal(): Map<String, Int> = mapOf("total" to service.total())

    @Operation(summary = "Najde vydaj podle ID")
    // TODO (7.13): Add @ApiResponses with two entries: 200 (found) and 404 (not found)
    //   Hint: @ApiResponses(
    //             ApiResponse(responseCode = "200", description = "Vydaj nalezen"),
    //             ApiResponse(responseCode = "404", description = "Vydaj nenalezen")
    //         )
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Expense {
        return service.findById(id)
            ?: throw ExpenseNotFoundException(id)
    }
}
