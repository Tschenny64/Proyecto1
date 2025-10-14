package com.example.proyecto1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormularioPago() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {


        Button(onClick = {
            // REDIRIGIR A PANTALLA INICIAL
        }) {
            Text("Cancelar")
        }

        Button(onClick = {
            // REDIRIGIR A RESUMEN DE PAGO
        }) {
            Text("Aceptar")
        }

    }

}


@Preview(showBackground = true)
@Composable
fun PreviewFormulario() {
    FormularioPago()
}