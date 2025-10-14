package com.example.proyecto1

import android.icu.number.NumberFormatter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants

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
        Text(text = "Tipo de pizza:")
        Row {
            RadioButton(selected = tipoPizza == "Romana", onClick = { tipoPizza = "Romana" })
            Text(text = "Romana")
        }
        Row {
            RadioButton(selected = tipoPizza == "Barbacoa", onClick = { tipoPizza = "Barbacoa" })
            Text(text = "Barbacoa")
        }
        Row {
            RadioButton(selected = tipoPizza == "Margarita", onClick = { tipoPizza = "Margarita" })
            Text(text = "Margarita")
        }
        if (tipoPizza == "Romana") {
            var conChampis by remember { mutableStateOf(false) }
            Row {
                RadioButton(selected = conChampis, onClick = { conChampis = true })
                Text("Con champiñones")
            }
            Row {
                RadioButton(selected = !conChampis, onClick = { conChampis = false })
                Text("Sin champiñones")
            }
        }
        if (tipoPizza == "Barbacoa") {
            var tipoCarne by remember { mutableStateOf("Cerdo") }
            Text("Tipo de carne:")
            Row {
                RadioButton(selected = tipoCarne == "Cerdo", onClick = { tipoCarne = "Cerdo" })
                Text("Cerdo")
            }
            Row {
                RadioButton(selected = tipoCarne == "Pollo", onClick = { tipoCarne = "Pollo" })
                Text("Pollo")
            }
            Row {
                RadioButton(selected = tipoCarne == "Ternera", onClick = { tipoCarne = "Ternera" })
                Text("Ternera")
            }
        }

        if (tipoPizza == "Margarita") {
            var conPina by remember { mutableStateOf(false) }
            var vegana by remember { mutableStateOf(false) }

            Row {
                RadioButton(selected = conPina, onClick = { conPina = true })
                Text("Con piña")
            }
            Row {
                RadioButton(selected = !conPina, onClick = { conPina = false })
                Text("Sin piña")
            }

            Row {
                RadioButton(selected = vegana, onClick = { vegana = true })
                Text("Versión vegana")
            }
            Row {
                RadioButton(selected = !vegana, onClick = { vegana = false })
                Text("Normal")
            }
        }
        var tamanoPizza by remember { mutableStateOf("Pequeña") }

        Text("Tamaño de la pizza:")
        Row {
            RadioButton(selected = tamanoPizza == "Pequeña", onClick = { tamanoPizza = "Pequeña" })
            Text("Pequeña (4,95 €)")
        }
        Row {
            RadioButton(selected = tamanoPizza == "Mediana", onClick = { tamanoPizza = "Mediana" })
            Text("Mediana (6,95 €)")
        }
        Row {
            RadioButton(selected = tamanoPizza == "Grande", onClick = { tamanoPizza = "Grande" })
            Text("Grande (10,95 €)")
        }
        var bebida by remember { mutableStateOf("Sin bebida") }

        Text("Bebida:")
        Row {
            RadioButton(selected = bebida == "Agua", onClick = { bebida = "Agua" })
            Text("Agua (2 €)")
        }
        Row {
            RadioButton(selected = bebida == "Cola", onClick = { bebida = "Cola" })
            Text("Cola (2,5 €)")
        }
        Row {
            RadioButton(selected = bebida == "Sin bebida", onClick = { bebida = "Sin bebida" })
            Text("Sin bebida (0 €)")
        }
        var cantidadPizza by remember { mutableStateOf(1) }
        Text("Cantidad de pizzas:")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                if (cantidadPizza > 1) cantidadPizza--
            }) {
                Text("-")
            }
            Text(
                text = cantidadPizza.toString(),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Button(onClick = {
                cantidadPizza++
            }) {
                Text("+")
            }
        }

        var cantidadBebida by remember { mutableStateOf(0) }
        Text("Cantidad de bebidas:")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                if (cantidadBebida > 0) cantidadBebida--
            }) {
                Text("-")
            }
            Text(
                text = cantidadBebida.toString(),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Button(onClick = {
                cantidadBebida++
            }) {
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
            text = "Precio total: %.2f €".format(precioTotal),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

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
                // REDIRIGIR A RESUMEN DEL PAGO
            }) {
                Text("Aceptar")
            }

        }


    }
}
@Preview(showBackground = true)
@Composable
fun PreviewFormularioPago() {
    RealizarPedido()
}