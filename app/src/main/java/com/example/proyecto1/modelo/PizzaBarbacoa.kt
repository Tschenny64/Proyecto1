package com.example.proyecto1.modelo

enum class TipoCarne {
    CERDO, POLLO, TERNERA
}

data class PizzaBarbacoa(
    val carne: TipoCarne
) : Pizza(nombre = "Barbacoa", TamanoPizza.PEQUENA)