package com.example.proyecto1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource

data class Pago(
    val tipoTarjeta: String,
    val numeroTarjeta: String,
    val fechaCaducidad: String,
    val cvc: String
)

@Composable
fun FormularioPago() {
    var tipoTarjeta by remember { mutableStateOf("VISA") }
    var numeroTarjeta by remember { mutableStateOf("") }
    var fechaCaducidad by remember { mutableStateOf("") }
    var cvc by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.titulo_pago),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(stringResource(R.string.tipo_tarjeta))
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = tipoTarjeta == "VISA", onClick = { tipoTarjeta = "VISA" })
            Text(stringResource(R.string.visa))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = tipoTarjeta == "MasterCard", onClick = { tipoTarjeta = "MasterCard" })
            Text(stringResource(R.string.mastercard))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = tipoTarjeta == "Euro 6000", onClick = { tipoTarjeta = "Euro 6000" })
            Text(stringResource(R.string.euro6000))
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numeroTarjeta,
            onValueChange = { numeroTarjeta = it },
            label = { Text(stringResource(R.string.numero_tarjeta)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = fechaCaducidad,
            onValueChange = { fechaCaducidad = it },
            label = { Text(stringResource(R.string.fecha_caducidad)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = cvc,
            onValueChange = { cvc = it },
            label = { Text(stringResource(R.string.cvc)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        Button(
            onClick = {
            }
        ) {
            Text(stringResource(R.string.confirmar_pago))
        }
    }
}
