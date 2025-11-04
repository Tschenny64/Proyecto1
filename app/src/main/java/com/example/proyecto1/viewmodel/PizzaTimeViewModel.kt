package com.example.proyecto1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto1.datos.listaUsuariosRegistrados
import com.example.proyecto1.modelo.Usuario
import com.example.proyecto1.modelo.uistate.PizzaTimeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PizzaTimeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PizzaTimeUIState())
    val uiState: StateFlow<PizzaTimeUIState> = _uiState.asStateFlow()

    private var usuarioActual: Usuario = listaUsuariosRegistrados[0]

}