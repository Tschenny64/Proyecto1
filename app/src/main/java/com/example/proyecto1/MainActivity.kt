package com.example.proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.proyecto1.pantallas.FormularioPago
import com.example.proyecto1.pantallas.ListarPedidos
import com.example.proyecto1.pantallas.RealizarPedido
import com.example.proyecto1.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                FormularioPago()
            }
        }
    }
}