package com.example.proyecto1.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto1.R
import com.example.proyecto1.ui.viewmodel.PizzeriaViewModel

@Composable
fun ResumenPedido(
    viewModel: PizzeriaViewModel = viewModel(),
    onCancelar: () -> Unit = {},
    onPagar: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
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
                    Text("${stringResource(R.string.pizza)}: ${uiState.value.pizzaElegida}")
                    Text("${stringResource(R.string.opcion)}: ${uiState.value.opcionElegida}")
                    Text("${stringResource(R.string.tamano)}: ${uiState.value.tamanoElegido}")
                    Text("${stringResource(R.string.bebida)}: ${uiState.value.bebidaElegida}")
                    Text("${stringResource(R.string.cantidad_pizzas)}: ${uiState.value.cantidadPizza}")
                    Text("${stringResource(R.string.cantidad_bebidas)}: ${uiState.value.cantidadBebida}")
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.precio_total, uiState.value.precioTotal),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { onCancelar() }) {
                    Text(stringResource(R.string.cancelar))
                }

                Button(onClick = {
                    viewModel.registrarPedidoActual()
                    onPagar()
                }) {
                    Text(stringResource(R.string.pagar))
                }
            }
        }
    }
}
