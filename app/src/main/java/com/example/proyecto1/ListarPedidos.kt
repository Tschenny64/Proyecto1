package com.example.proyecto1

import android.R.attr.top
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
@Composable
fun ListarPedidos() {
    val listaPedidos = listOf(
        Pedido("Barbacoa", "Pollo", "Mediana", "Cola", 2, 2),
        Pedido("Carbonara", "Bacon", "Grande", "Agua", 1, 1),
        Pedido("Mexicana", "Ternera", "Pequeña", "Fanta", 3, 2)
    )

    var pedidoSeleccionado by remember { mutableStateOf<Pedido?>(null) }

    Column(modifier = Modifier.padding(26.dp).padding(top = 30.dp)) {
        Text(
            text = stringResource(R.string.titulo_listar_pedidos),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(listaPedidos) { pedido ->
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
                        Text("Ver detalles", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        pedidoSeleccionado?.let { pedido ->
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
