package com.example.proyecto1.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto1.R
import com.example.proyecto1.modelo.Pedido
import com.example.proyecto1.ui.viewmodel.PizzeriaViewModel

@Composable
fun ListarPedidos(
    viewModel: PizzeriaViewModel,
    modifier: Modifier = Modifier
) {
    val pedidos = viewModel.pedidos.collectAsState()
    var pedidoSeleccionado by remember { mutableStateOf<Pedido?>(null) }

    Column(
        modifier = Modifier
            .padding(26.dp)
            .padding(top = 30.dp)
    ) {
        Text(
            text = stringResource(R.string.titulo_listar_pedidos),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(pedidos.value) { pedido ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .clickable { pedidoSeleccionado = pedido }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("${stringResource(R.string.pizza)}: ${pedido.pizza}")
                        Text("${stringResource(R.string.tamano)}: ${pedido.tamanoPizza}")
                        Text("${stringResource(R.string.bebida)}: ${pedido.bebida}")
                        Text(stringResource(R.string.ver_detalles), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        pedidoSeleccionado?.let { pedido ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("${stringResource(R.string.pizza)}: ${pedido.pizza}")
                    Text("${stringResource(R.string.opcion)}: ${pedido.opcionPizza}")
                    Text("${stringResource(R.string.tamano)}: ${pedido.tamanoPizza}")
                    Text("${stringResource(R.string.bebida)}: ${pedido.bebida}")
                    Text("${stringResource(R.string.cantidad_pizzas)}: ${pedido.cantidadPizza}")
                    Text("${stringResource(R.string.cantidad_bebidas)}: ${pedido.cantidadBebida}")
                    Text(stringResource(R.string.precio_total, pedido.precioTotal))
                }
            }
        }
    }
}
