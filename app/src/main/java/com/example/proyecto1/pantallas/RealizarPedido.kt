package com.example.proyecto1.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto1.R
import com.example.proyecto1.ui.viewmodel.PizzeriaViewModel

@Composable
fun RealizarPedido(
    viewModel: PizzeriaViewModel = viewModel(),
    onCancelar: () -> Unit = {},
    onAceptar: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        ) {
            Text(stringResource(R.string.tipo_pizza), fontWeight = FontWeight.Bold, fontSize = 18.sp)

            val pizzas = listOf(
                stringResource(R.string.romana),
                stringResource(R.string.barbacoa),
                stringResource(R.string.margarita)
            )

            pizzas.forEach { tipo ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = uiState.pizzaElegida == tipo,
                        onClick = { viewModel.seleccionarPizza(tipo) }
                    )
                    Text(tipo)
                }
            }

            Spacer(Modifier.height(12.dp))

            when (uiState.pizzaElegida) {
                stringResource(R.string.romana) -> {
                    Text(stringResource(R.string.extras), fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    val opciones = listOf(
                        stringResource(R.string.con_champis),
                        stringResource(R.string.sin_champis)
                    )
                    opciones.forEach { opcion ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = uiState.opcionElegida == opcion,
                                onClick = { viewModel.seleccionarOpcionPizza(opcion) }
                            )
                            Text(opcion)
                        }
                    }
                }
                stringResource(R.string.barbacoa) -> {
                    Text(stringResource(R.string.tipo_carne), fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    val opciones = listOf(
                        stringResource(R.string.cerdo),
                        stringResource(R.string.pollo),
                        stringResource(R.string.ternera)
                    )
                    opciones.forEach { opcion ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = uiState.opcionElegida == opcion,
                                onClick = { viewModel.seleccionarOpcionPizza(opcion) }
                            )
                            Text(opcion)
                        }
                    }
                }
                stringResource(R.string.margarita) -> {
                    Text(stringResource(R.string.extras), fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    val opciones = listOf(
                        stringResource(R.string.con_pina),
                        stringResource(R.string.sin_pina),
                        stringResource(R.string.vegana),
                        stringResource(R.string.normal)
                    )
                    opciones.forEach { opcion ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = uiState.opcionElegida == opcion,
                                onClick = { viewModel.seleccionarOpcionPizza(opcion) }
                            )
                            Text(opcion)
                        }
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            Text(stringResource(R.string.tamano_pizza), fontWeight = FontWeight.Bold, fontSize = 18.sp)
            val tamanos = listOf(
                "PEQUENA" to stringResource(R.string.pequena),
                "MEDIANA" to stringResource(R.string.mediana),
                "GRANDE" to stringResource(R.string.grande)
            )

            tamanos.forEach { (key, label) ->
                Row {
                    RadioButton(
                        selected = uiState.tamanoElegido == key,
                        onClick = { viewModel.seleccionarTamano(key) }
                    )
                    Text(label)
                }
            }

        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(R.string.bebida), fontWeight = FontWeight.Bold, fontSize = 18.sp)
            val bebidas = listOf(
                stringResource(R.string.agua),
                stringResource(R.string.cola),
                stringResource(R.string.sin_bebida)
            )
            bebidas.forEach { bebida ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = uiState.bebidaElegida == bebida,
                        onClick = { viewModel.seleccionarBebida(bebida) }
                    )
                    Text(bebida)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 560.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.bebidaElegida != stringResource(R.string.sin_bebida)) {
            Text(stringResource(R.string.cantidad_bebidas), fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { viewModel.cambiarCantidadBebida(-1) }) { Text("-") }
                Text(uiState.cantidadBebida.toString(), modifier = Modifier.padding(horizontal = 16.dp))
                Button(onClick = { viewModel.cambiarCantidadBebida(1) }) { Text("+") }
            }
            Spacer(Modifier.height(12.dp))
        }

        Text(stringResource(R.string.cantidad_pizzas), fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { viewModel.cambiarCantidadPizza(-1) }) { Text("-") }
            Text(uiState.cantidadPizza.toString(), modifier = Modifier.padding(horizontal = 16.dp))
            Button(onClick = { viewModel.cambiarCantidadPizza(1) }) { Text("+") }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.precio_total, uiState.precioTotal),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = onCancelar) { Text(stringResource(R.string.cancelar)) }
            Button(onClick = onAceptar) { Text(stringResource(R.string.aceptar)) }
        }
    }
}
