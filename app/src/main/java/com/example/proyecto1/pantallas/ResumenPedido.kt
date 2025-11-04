package com.example.proyecto1.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.proyecto1.R

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
    val pedido = Pedido(
        tipoPizza = stringResource(R.string.barbacoa),
        carne = stringResource(R.string.pollo),
        tamano = stringResource(R.string.mediana),
        bebida = stringResource(R.string.cola),
        cantidadPizza = 2,
        cantidadBebida = 1
    )

    val precioPizza = 6.95
    val precioBebida = 2.5
    val precioTotal = (precioPizza * pedido.cantidadPizza) + (precioBebida * pedido.cantidadBebida)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.titulo_resumen),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("${stringResource(R.string.pizza)}: ${pedido.tipoPizza}")
                Text("${stringResource(R.string.carne)}: ${pedido.carne}")
                Text("${stringResource(R.string.tamano)}: ${pedido.tamano}")
                Text("${stringResource(R.string.bebida)}: ${pedido.bebida}")
                Text("${stringResource(R.string.cantidad_pizzas)}: ${pedido.cantidadPizza}")
                Text("${stringResource(R.string.cantidad_bebidas)}: ${pedido.cantidadBebida}")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.precio_total, precioTotal),
            style = MaterialTheme.typography.titleLarge,
            //cambiar de color
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                //  cancelar
            }) {
                Text(stringResource(R.string.cancelar))
            }

            Button(onClick = {
                //  pagar
            }) {
                Text(stringResource(R.string.pagar))
            }
        }
    }
}
