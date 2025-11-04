package com.example.proyecto1.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.proyecto1.R

data class DatosPago(
    val nombreCliente: String,
    val tipoTarjeta: String,
    val ultimosDigitos: String,
    val cantidadPagada: Double
)

@Composable
fun ResumenPago() {
    val datosPago = DatosPago(
        nombreCliente = "Iker Catala",
        tipoTarjeta = "VISA",
        ultimosDigitos = "**** 9999",
        cantidadPagada = 4.95
    )

    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.titulo_resumen_pago),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("${stringResource(R.string.nombre)}: ${datosPago.nombreCliente}")
                Text("${stringResource(R.string.tipo_tarjeta)}: ${datosPago.tipoTarjeta}")
                Text("${stringResource(R.string.numero_tarjeta)}: ${datosPago.ultimosDigitos}")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {

            }) {
                Text(stringResource(R.string.aceptar))
            }

            Button(onClick = {

            }) {
                Text(stringResource(R.string.enviar))
            }
        }
    }

}
