package dev.workshop.expense

// ═══ STEP 7 — OpenAPI @Schema/@ApiResponse ═══  Fill in the TODO blocks below, then run: ./mvnw spring-boot:run   (solution: ../step-07-final/)

// TODO (7.5): Import the Schema annotation
//   Hint: import io.swagger.v3.oas.annotations.media.Schema

// TODO (7.6): Annotate the data class itself with @Schema to describe what an Expense represents
//   Hint: @Schema(description = "Expense in the system")

// TODO (7.7): Annotate each field with @Schema — add one annotation line before each property
//   Hint: @Schema(description = "Unique expense ID", example = "1")
//         @Schema(description = "Expense description", example = "Lunch at restaurant")
//         @Schema(description = "Amount in CZK", example = "150")
//         @Schema(description = "Expense date YYYY-MM-DD", example = "2024-01-15")
data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)
