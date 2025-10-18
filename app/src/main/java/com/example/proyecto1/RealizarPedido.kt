package com.example.proyecto1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.proyecto1.R

@Composable
fun RealizarPedido() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var tipoPizza by remember { mutableStateOf("Romana") }
        Text(text = stringResource(R.string.tipo_pizza))
        Row {
            RadioButton(selected = tipoPizza == "Romana", onClick = { tipoPizza = "Romana" })
            Text(text = stringResource(R.string.romana))
        }
        Row {
            RadioButton(selected = tipoPizza == "Barbacoa", onClick = { tipoPizza = "Barbacoa" })
            Text(text = stringResource(R.string.barbacoa))
        }
        Row {
            RadioButton(selected = tipoPizza == "Margarita", onClick = { tipoPizza = "Margarita" })
            Text(text = stringResource(R.string.margarita))
        }

        if (tipoPizza == "Romana") {
            var conChampis by remember { mutableStateOf(false) }
            Row {
                RadioButton(selected = conChampis, onClick = { conChampis = true })
                Text(stringResource(R.string.con_champis))
            }
            Row {
                RadioButton(selected = !conChampis, onClick = { conChampis = false })
                Text(stringResource(R.string.sin_champis))
            }
        }

        if (tipoPizza == "Barbacoa") {
            var tipoCarne by remember { mutableStateOf("Cerdo") }
            Text(stringResource(R.string.tipo_carne))
            Row {
                RadioButton(selected = tipoCarne == "Cerdo", onClick = { tipoCarne = "Cerdo" })
                Text(stringResource(R.string.cerdo))
            }
            Row {
                RadioButton(selected = tipoCarne == "Pollo", onClick = { tipoCarne = "Pollo" })
                Text(stringResource(R.string.pollo))
            }
            Row {
                RadioButton(selected = tipoCarne == "Ternera", onClick = { tipoCarne = "Ternera" })
                Text(stringResource(R.string.ternera))
            }
        }

        if (tipoPizza == "Margarita") {
            var conPina by remember { mutableStateOf(false) }
            var vegana by remember { mutableStateOf(false) }

            Row {
                RadioButton(selected = conPina, onClick = { conPina = true })
                Text(stringResource(R.string.con_pina))
            }
            Row {
                RadioButton(selected = !conPina, onClick = { conPina = false })
                Text(stringResource(R.string.sin_pina))
            }

            Row {
                RadioButton(selected = vegana, onClick = { vegana = true })
                Text(stringResource(R.string.vegana))
            }
            Row {
                RadioButton(selected = !vegana, onClick = { vegana = false })
                Text(stringResource(R.string.normal))
            }
        }

        var tamanoPizza by remember { mutableStateOf("Pequeña") }
        Text(stringResource(R.string.tamano_pizza))
        Row {
            RadioButton(selected = tamanoPizza == "Pequeña", onClick = { tamanoPizza = "Pequeña" })
            Text(stringResource(R.string.pequena))
        }
        Row {
            RadioButton(selected = tamanoPizza == "Mediana", onClick = { tamanoPizza = "Mediana" })
            Text(stringResource(R.string.mediana))
        }
        Row {
            RadioButton(selected = tamanoPizza == "Grande", onClick = { tamanoPizza = "Grande" })
            Text(stringResource(R.string.grande))
        }

        var bebida by remember { mutableStateOf("Sin bebida") }
        Text(stringResource(R.string.bebida))
        Row {
            RadioButton(selected = bebida == "Agua", onClick = { bebida = "Agua" })
            Text(stringResource(R.string.agua))
        }
        Row {
            RadioButton(selected = bebida == "Cola", onClick = { bebida = "Cola" })
            Text(stringResource(R.string.cola))
        }
        Row {
            RadioButton(selected = bebida == "Sin bebida", onClick = { bebida = "Sin bebida" })
            Text(stringResource(R.string.sin_bebida))
        }

        var cantidadPizza by remember { mutableStateOf(1) }
        Text(stringResource(R.string.cantidad_pizzas))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { if (cantidadPizza > 1) cantidadPizza-- }) {
                Text("-")
            }
            Text(text = cantidadPizza.toString(), modifier = Modifier.padding(horizontal = 16.dp))
            Button(onClick = { cantidadPizza++ }) {
                Text("+")
            }
        }

        var cantidadBebida by remember { mutableStateOf(0) }
        Text(stringResource(R.string.cantidad_bebidas))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { if (cantidadBebida > 0) cantidadBebida-- }) {
                Text("-")
            }
            Text(text = cantidadBebida.toString(), modifier = Modifier.padding(horizontal = 16.dp))
            Button(onClick = { cantidadBebida++ }) {
                Text("+")
            }
        }

        val precioPizza = when (tamanoPizza) {
            "Pequeña" -> 4.95
            "Mediana" -> 6.95
            "Grande" -> 10.95
            else -> 0.0
        }

        val precioBebida = when (bebida) {
            "Agua" -> 2.0
            "Cola" -> 2.5
            else -> 0.0
        }

        val precioTotal = (precioPizza * cantidadPizza) + (precioBebida * cantidadBebida)

        Text(
            text = stringResource(R.string.precio_total, precioTotal),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {
                // Volver a pantalla inicial
            }) {
                Text(stringResource(R.string.cancelar))
            }

            Button(onClick = {
                // Ir a resumen del pedido
            }) {
                Text(stringResource(R.string.aceptar))
            }
        }
    }
}
