package com.example.proyecto1.modelo.uistate

import com.example.proyecto1.modelo.Pedido

data class PizzaTimeUIState(

    val pizzaElegida: String = "",
    val opcionElegida: String = "",
    val tamanoElegido: String = "",
    val bebidaElegida: String = "",
    val cantidadPizza: Int = 1,
    val cantidadBebida: Int = 0,
    val precioTotal: Double = 0.0,
    val idpedido: Int = 0,
    val pizza: String = "",
    val tamanoPizza: String = "",
    val bebida: String = "",
    val precioPizza: Double = 0.0,
    val precioBebida: Double = 0.0,
    val tipoTarjeta: String = "",
    val pedidos: List<Pedido> = emptyList()

)