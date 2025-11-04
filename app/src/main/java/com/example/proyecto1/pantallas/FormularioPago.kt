package com.example.proyecto1.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyecto1.R
import com.example.proyecto1.modelo.tipoTarjeta
import com.example.proyecto1.viewmodel.PizzaTimeViewModel

@Composable
fun FormularioPago(
    viewModel: PizzaTimeViewModel = viewModel()
) {
    val pago = viewModel.pagoActual.collectAsState()

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
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = pago.value.tipoTarjeta == tipoTarjeta.VISA,
                onClick = { viewModel.actualizarTipo(tipoTarjeta.VISA) }
            )
            Text(stringResource(R.string.visa))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = pago.value.tipoTarjeta == tipoTarjeta.MasterCard,
                onClick = { viewModel.actualizarTipo(tipoTarjeta.MasterCard) }
            )
            Text(stringResource(R.string.mastercard))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = pago.value.tipoTarjeta == tipoTarjeta.Euro6000,
                onClick = { viewModel.actualizarTipo(tipoTarjeta.Euro6000) }
            )
            Text(stringResource(R.string.euro6000))
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = pago.value.numeroTarjeta,
            onValueChange = { viewModel.actualizarNumero(it) },
            label = { Text(stringResource(R.string.numero_tarjeta)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = pago.value.fechaCaducidad,
            onValueChange = { viewModel.actualizarFecha(it) },
            label = { Text(stringResource(R.string.fecha_caducidad)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = pago.value.cvc,
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
        Button(
            onClick = {

            },

        ) {
            Text(stringResource(R.string.cancelar))
        }
            Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = {

            },
        ) {
            Text(stringResource(R.string.aceptar))
        }
        }

    }
}