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

@Composable
fun FormularioPago() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Formulario de pago",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Tipo de tarjeta
        var tipoTarjeta by remember { mutableStateOf("VISA") }

        Text("Tipo de tarjeta:")
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = tipoTarjeta == "VISA", onClick = { tipoTarjeta = "VISA" })
            Text("VISA")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = tipoTarjeta == "MasterCard", onClick = { tipoTarjeta = "MasterCard" })
            Text("MasterCard")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = tipoTarjeta == "Euro 6000", onClick = { tipoTarjeta = "Euro 6000" })
            Text("Euro 6000")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Número de tarjeta
        var numeroTarjeta by remember { mutableStateOf("") }
        OutlinedTextField(
            value = numeroTarjeta,
            onValueChange = { numeroTarjeta = it },
            label = { Text("Número de tarjeta") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // Fecha de caducidad
        var fechaCaducidad by remember { mutableStateOf("") }
        OutlinedTextField(
            value = fechaCaducidad,
            onValueChange = { fechaCaducidad = it },
            label = { Text("Fecha de caducidad (MM/AA)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // CVC
        var cvc by remember { mutableStateOf("") }
        OutlinedTextField(
            value = cvc,
            onValueChange = { cvc = it },
            label = { Text("CVC") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Botón de confirmar
        Button(
            onClick = {
                // Aquí iría la lógica de pago
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Confirmar pago")
        }
    }
}