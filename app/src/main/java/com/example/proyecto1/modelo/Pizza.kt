package com.example.proyecto1.modelo

open class Pizza(
    open val nombre: String = ""
)
class Margarita(
    val conPina: Boolean = false,
    val esVegana: Boolean = false
) : Pizza("Margarita")

class Romana(
    val conChampinones: Boolean = false
) : Pizza("Romana")

enum class TipoCarne {
    CERDO, POLLO, TERNERA
}

class Barbacoa(
    val tipoCarne: TipoCarne
) : Pizza("Barbacoa")
