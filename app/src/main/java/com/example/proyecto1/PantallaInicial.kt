package com.example.proyecto1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaInicial() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(46.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.titulo_pantalla_inicial),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.pizzatimelogo),
            contentDescription = "",
            modifier = Modifier
                .size(400.dp)
                .padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
        Text("${stringResource(R.string.nombre)}: Iker", fontSize = 18.sp)
        Text("${stringResource(R.string.apellidos)}: Catala", fontSize = 18.sp)
        Text("${stringResource(R.string.correo)}: ikercatala@gmail.com", fontSize = 18.sp)
        Text("${stringResource(R.string.telefono)}: 5287932879", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                //REDIRIGIR REALIZAR PEDIDO
            },
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
        ) {
            Text(stringResource(R.string.realizar_pedido))
        }

        Button(
            onClick = {
                // REDIRIGIR LISTAR PEDIDOS
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.listar_pedidos))
        }
    }
}
