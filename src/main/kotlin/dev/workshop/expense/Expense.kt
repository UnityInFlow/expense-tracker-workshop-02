package dev.workshop.expense

// STEP 5 — OpenAPI: document this model so Swagger shows field descriptions and examples.
// TODO (step 5): annotate the class with @Schema(description = "...") and each field with
//   @Schema(description = "...", example = "..."). You will need:
//   import io.swagger.v3.oas.annotations.media.Schema
data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)
