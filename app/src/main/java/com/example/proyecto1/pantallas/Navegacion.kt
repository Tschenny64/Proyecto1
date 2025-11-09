package com.example.proyecto1.pantallas

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyecto1.R
import com.example.proyecto1.ui.viewmodel.PizzeriaViewModel
enum class Pantallas(@StringRes val titulo: Int) {
    PantallaInicial(R.string.titulo_pantalla_inicial),
    RealizarPedido(R.string.realizar_pedido),
    ListarPedidos(R.string.listar_pedidos),
    ResumenPedido(R.string.resumen_pedido),
    FormularioPago(R.string.formulario_pago),
    ResumenPago(R.string.resumen_pago)
}

@Composable
fun Navegacion(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
    val viewModel: PizzeriaViewModel = viewModel()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val pantallaActual = Pantallas.valueOf(
        backStackEntry?.destination?.route ?: Pantallas.PantallaInicial.name
    )

    Scaffold(
        topBar = {
            AppTopBar(
                pantallaActual = pantallaActual,
                puedeNavegarAtras = navController.previousBackStackEntry != null,
                onNavegarAtras = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Pantallas.PantallaInicial.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Pantallas.PantallaInicial.name) {
                PantallaInicial(
                    onRealizarPedido = { navController.navigate(Pantallas.RealizarPedido.name) },
                    onListarPedidos = { navController.navigate(Pantallas.ListarPedidos.name) }
                )
            }

            composable(Pantallas.RealizarPedido.name) {

                RealizarPedido(
                    viewModel = viewModel,
                    onCancelar = { navController.popBackStack() },
                    onAceptar = { navController.navigate(Pantallas.ResumenPedido.name) }
                )
            }

            composable(Pantallas.ListarPedidos.name) {
                ListarPedidos(viewModel = viewModel)
            }

            composable(Pantallas.ResumenPedido.name) {
                ResumenPedido(
                    viewModel = viewModel,
                    onCancelar = { navController.popBackStack() },
                    onPagar = { navController.navigate(Pantallas.FormularioPago.name) }
                )
            }

            composable(Pantallas.FormularioPago.name) {
                FormularioPago(
                    viewModel = viewModel,
                    onCancelar = { navController.popBackStack(Pantallas.PantallaInicial.name, inclusive = false) },
                    onAceptar = { navController.navigate(Pantallas.ResumenPago.name) }
                )
            }

            composable(Pantallas.ResumenPago.name) {
                ResumenPago(
                    viewModel = viewModel,
                    onAceptar = {
                        navController.navigate(Pantallas.PantallaInicial.name) {
                            popUpTo(Pantallas.PantallaInicial.name) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    pantallaActual: Pantallas,
    puedeNavegarAtras: Boolean,
    onNavegarAtras: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(id = pantallaActual.titulo)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (puedeNavegarAtras) {
                IconButton(onClick = onNavegarAtras) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.atras)
                    )
                }
            }
        },
        modifier = modifier
    )
}
