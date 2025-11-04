package com.example.proyecto1.datos

import com.example.proyecto1.R
import com.example.proyecto1.modelo.Usuario

val listaUsuariosRegistrados: List<Usuario> = listOf(
    Usuario(
        id = 1,
        nombre = "Iker",
        apellido = "Catala",
        correo = "ikecatoli@alu.edu.gva.es",
        telefono = "123456789",
        fotoPerfil = R.drawable.user
    ),
)