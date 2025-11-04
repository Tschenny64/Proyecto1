package com.example.proyecto1.modelo

data class PizzaRomana(
    val champinones: Boolean
) : Pizza(nombre = "Romana", TamanoPizza.PEQUENA)