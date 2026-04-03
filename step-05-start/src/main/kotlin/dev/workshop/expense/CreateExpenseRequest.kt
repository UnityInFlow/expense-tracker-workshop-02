package dev.workshop.expense

// TODO: Pridejte validacni anotace:
//   @field:NotBlank(message = "Popis nesmi byt prazdny")
//   @field:Size(min = 2, max = 100, message = "Popis musi mit 2-100 znaku")
//   na description
//
//   @field:Min(value = 1, message = "Castka musi byt alespon 1 Kc")
//   na amount
//
// POZOR: V Kotlin data class pouzijte @field: prefix!
// Import: import jakarta.validation.constraints.*
data class CreateExpenseRequest(
    val description: String,
    val amount: Int
)
