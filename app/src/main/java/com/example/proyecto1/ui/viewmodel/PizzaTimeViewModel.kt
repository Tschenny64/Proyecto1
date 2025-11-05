package com.example.proyecto1.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto1.datos.listaUsuariosRegistrados
import com.example.proyecto1.modelo.Pago
import com.example.proyecto1.modelo.Usuario
import com.example.proyecto1.modelo.tipoTarjeta
import com.example.proyecto1.modelo.uistate.PizzaTimeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PizzaTimeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PizzaTimeUIState())
    val uiState: StateFlow<PizzaTimeUIState> = _uiState.asStateFlow()

    private var usuarioActual: Usuario = listaUsuariosRegistrados[0]


    // --- NUEVO BLOQUE PARA PAGO ---
    private val _pagoActual = MutableStateFlow(
        Pago(
            id = 0,
            tipoTarjeta = tipoTarjeta.VISA,
            numeroTarjeta = "",
            fechaCaducidad = "",
            cvc = ""
        )
    )
    val pagoActual: StateFlow<Pago> = _pagoActual.asStateFlow()

    fun actualizarTipo(t: tipoTarjeta) {
        _pagoActual.value = _pagoActual.value.copy(tipoTarjeta = t)
    }

    fun actualizarNumero(n: String) {
        if (n.length <= 16 && n.all { it.isDigit() })
            _pagoActual.value = _pagoActual.value.copy(numeroTarjeta = n)
    }

    fun actualizarFecha(f: String) {
        _pagoActual.value = _pagoActual.value.copy(fechaCaducidad = f)
    }

    fun actualizarCvc(c: String) {
        if (c.length <= 3 && c.all { it.isDigit() })
            _pagoActual.value = _pagoActual.value.copy(cvc = c)
    }
}