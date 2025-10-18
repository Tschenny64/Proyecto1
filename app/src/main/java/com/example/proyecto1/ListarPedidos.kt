package com.example.proyecto1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ListarPedidos() {
    val listaPedidos = listOf(
        Pedido("Barbacoa", "Pollo", "Mediana", "Cola", 2, 2),
        Pedido("Carbonara", "Bacon", "Grande", "Agua", 1, 1),
        Pedido("Mexicana", "Ternera", "Pequeña", "Fanta", 3, 2)
    )

    var pedidoSeleccionado by remember { mutableStateOf<Pedido?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.titulo_listar_pedidos),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            itemsIndexed(listaPedidos) { index, pedido ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .clickable { pedidoSeleccionado = pedido }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("${stringResource(R.string.pizza)}: ${pedido.tipoPizza}")
                        Text("${stringResource(R.string.tamano)}: ${pedido.tamano}")
                        Text("${stringResource(R.string.bebida)}: ${pedido.bebida}")
                        Text(stringResource(R.string.ver_detalle))
                    }
                }
            }
        }

        pedidoSeleccionado?.let { pedido ->
            Spacer(modifier = Modifier.height(24.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("${stringResource(R.string.pizza)}: ${pedido.tipoPizza}")
                    Text("${stringResource(R.string.carne)}: ${pedido.carne}")
                    Text("${stringResource(R.string.tamano)}: ${pedido.tamano}")
                    Text("${stringResource(R.string.bebida)}: ${pedido.bebida}")
                    Text("${stringResource(R.string.cantidad_pizzas)}: ${pedido.cantidadPizza}")
                    Text("${stringResource(R.string.cantidad_bebidas)}: ${pedido.cantidadBebida}")
                }
            }
        }
    }
}
