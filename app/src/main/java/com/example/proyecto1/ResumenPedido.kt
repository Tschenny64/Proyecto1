package com.example.proyecto1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun ResumenPedido() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Resumen del pedido",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Variables simuladas
        var tipoPizza by remember { mutableStateOf("Barbacoa") }
        var carne by remember { mutableStateOf("Pollo") }
        var tamano by remember { mutableStateOf("Mediana") }
        var bebida by remember { mutableStateOf("Cola") }
        var cantidadPizza by remember { mutableStateOf(2) }
        var cantidadBebida by remember { mutableStateOf(2) }

        val precioPizza = when (tamano) {
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

        // Mostrar resumen
        Text("Pizza: $tipoPizza ($carne)")
        Text("Tamaño: $tamano")
        Text("Bebida: $bebida")
        Text("Cantidad de pizzas: $cantidadPizza")
        Text("Cantidad de bebidas: $cantidadBebida")
        Text(
            text = "Precio total: %.2f €".format(precioTotal),
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botones
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                // REDIRIGIR A LA PAGINA PRINCIPAL
            }) {
                Text("Cancelar")
            }

            Button(onClick = {
                // REDIRIGIR FORMULARIO PAGO
            }) {
                Text("Pagar")
            }
        }
    }
}
