package com.example.proyecto1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


data class Pedido(
    val tipoPizza: String,
    val carne: String,
    val tamano: String,
    val bebida: String,
    val cantidadPizza: Int,
    val cantidadBebida: Int
)
@Composable
fun ResumenPedido() {
    val pedido by remember {
        mutableStateOf(
            Pedido(
                tipoPizza = "Barbacoa",
                carne = "Pollo",
                tamano = "Mediana",
                bebida = "Cola",
                cantidadPizza = 2,
                cantidadBebida = 2
            )
        )
    }

    val precioTotal = calcularPrecio(pedido)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.titulo_resumen),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text("${stringResource(R.string.pizza)}: ${pedido.tipoPizza} (${pedido.carne})")
        Text("${stringResource(R.string.tamano)}: ${pedido.tamano}")
        Text("${stringResource(R.string.bebida)}: ${pedido.bebida}")
        Text("${stringResource(R.string.cantidad_pizzas)}: ${pedido.cantidadPizza}")
        Text("${stringResource(R.string.cantidad_bebidas)}: ${pedido.cantidadBebida}")
        Text(
            text = "${stringResource(R.string.precio_total)}: %.2f €".format(precioTotal),
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                // Acción de cancelar
            }) {
                Text(stringResource(R.string.cancelar))
            }

            Button(onClick = {
                // Acción de pagar
            }) {
                Text(stringResource(R.string.pagar))
            }
        }
    }
}

fun calcularPrecio(p: Pedido): Double {
    val precioPizza = when (p.tamano) {
        "Pequeña" -> 4.95
        "Mediana" -> 6.95
        "Grande" -> 10.95
        else -> 0.0
    }
    val precioBebida = when (p.bebida) {
        "Agua" -> 2.0
        "Cola" -> 2.5
        else -> 0.0
    }
    return (precioPizza * p.cantidadPizza) + (precioBebida * p.cantidadBebida)
}