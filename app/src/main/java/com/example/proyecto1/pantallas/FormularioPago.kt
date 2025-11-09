package com.example.proyecto1.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto1.R
import com.example.proyecto1.ui.viewmodel.PizzeriaViewModel

@Composable
fun FormularioPago(
    viewModel: PizzeriaViewModel = viewModel(),
    onCancelar: () -> Unit = {},
    onAceptar: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val tipoPago = viewModel.tipoPagoSeleccionado.collectAsState()
    val numeroTarjeta = viewModel.numeroTarjeta.collectAsState()
    val fechaCaducidad = viewModel.fechaCaducidad.collectAsState()
    val cvc = viewModel.cvc.collectAsState()
    val formularioValido = viewModel.formularioValido.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.titulo_pago),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(stringResource(R.string.tipo_tarjeta), fontWeight = FontWeight.Bold)

        viewModel.opcionesPago.forEach { opcion ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = tipoPago.value == opcion,
                    onClick = { viewModel.seleccionarOpcionPago(opcion) }
                )
                Text(opcion.nombre)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numeroTarjeta.value,
            onValueChange = { viewModel.actualizarNumeroTarjeta(it) },
            label = { Text(stringResource(R.string.numero_tarjeta)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = fechaCaducidad.value,
            onValueChange = { viewModel.actualizarFechaCaducidad(it) },
            label = { Text(stringResource(R.string.fecha_caducidad)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = cvc.value,
            onValueChange = { viewModel.actualizarCvc(it) },
            label = { Text(stringResource(R.string.cvc)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = onCancelar) {
                Text(stringResource(R.string.cancelar))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    if (formularioValido.value) {
                        onAceptar()
                    }
                },
                enabled = formularioValido.value
            ) {
                Text(stringResource(R.string.aceptar))
            }
        }
    }
}
