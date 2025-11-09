package com.example.proyecto1.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto1.R
import com.example.proyecto1.ui.viewmodel.PizzeriaViewModel

@Composable
fun PantallaInicial(
    viewModel: PizzeriaViewModel = viewModel(),
    onRealizarPedido: () -> Unit = {},
    onListarPedidos: () -> Unit = {},
    modifier: Modifier = Modifier
) {
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


        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onRealizarPedido() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            Text(stringResource(R.string.realizar_pedido))
        }

        Button(
            onClick = { onListarPedidos() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.listar_pedidos))
        }
    }
}
