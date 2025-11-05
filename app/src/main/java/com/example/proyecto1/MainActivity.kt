package com.example.proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.proyecto1.pantallas.FormularioPago
import com.example.proyecto1.pantallas.ListarPedidos
import com.example.proyecto1.pantallas.PantallaInicial
import com.example.proyecto1.pantallas.RealizarPedido
import com.example.proyecto1.pantallas.ResumenPago
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
