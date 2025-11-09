package com.example.proyecto1.pantallas

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto1.R
import com.example.proyecto1.ui.viewmodel.PizzeriaViewModel

@Composable
fun ResumenPago(
    viewModel: PizzeriaViewModel = viewModel(),
    onAceptar: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val pedidos = viewModel.pedidos.collectAsState()
    val tipoPago = viewModel.tipoPagoSeleccionado.collectAsState()
    val numeroTarjeta = viewModel.numeroTarjeta.collectAsState()
    val context = LocalContext.current

    val pedidoActual = pedidos.value.lastOrNull()

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
                Text("${stringResource(R.string.nombre)}: Iker Catala")
                Text("${stringResource(R.string.tipo_tarjeta)}: ${tipoPago.value.nombre}")
                Text("${stringResource(R.string.numero_tarjeta)}: **** ${numeroTarjeta.value.takeLast(4)}")
                pedidoActual?.let {
                    Text(stringResource(R.string.precio_total, pedidoActual.precioTotal))

                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                onAceptar()
            }) {
                Text(stringResource(R.string.aceptar))
            }

            Button(onClick = {
            //enviar justificante
            }) {
                Text(stringResource(R.string.enviar))
            }
        }
    }
}
