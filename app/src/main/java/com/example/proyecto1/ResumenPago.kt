package com.example.proyecto1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun ResumenPago() {
    val pago by remember {
        mutableStateOf(
            Pago(
                tipoTarjeta = "VISA",
                numeroTarjeta = "1234 5678 9012 3456",
                fechaCaducidad = "12/27",
                cvc = "123"
            )
        )
    }

    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.titulo_resumen_pago),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text("${stringResource(R.string.tipo_tarjeta)}: ${pago.tipoTarjeta}")
        Text("${stringResource(R.string.numero_tarjeta)}: ${pago.numeroTarjeta}")
        Text("${stringResource(R.string.fecha_caducidad)}: ${pago.fechaCaducidad}")
        Text("${stringResource(R.string.cvc)}: ${pago.cvc}")

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
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
