package com.example.proyecto1.modelo

data class Usuario (
    val id: Int,
    val nombre: String,
    val apellido: String,
    val correo: String,
    val telefono: String,
    val fotoPerfil: Int
)