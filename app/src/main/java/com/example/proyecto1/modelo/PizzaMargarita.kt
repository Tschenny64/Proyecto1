package com.example.proyecto1.modelo

data class PizzaMargarita(
    val pina: Boolean,
    val vegana: Boolean
) : Pizza(nombre = "Margarita", TamanoPizza.PEQUENA)