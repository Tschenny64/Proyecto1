package com.example.proyecto1.modelo

open class Pizza(
    open val nombre: String,
    open val tamano: TamanoPizza
)

enum class TamanoPizza{
    PEQUENA, MEDIANA, GRANDE
}