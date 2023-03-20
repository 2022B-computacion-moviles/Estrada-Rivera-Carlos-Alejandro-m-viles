package com.example.examen_crud_firestore.model

import java.time.LocalDate
class User(
    var id: Int,
    var idAplicacion: Int,

    var nombre: String,
    var apellido: String,
    var correo: String,
    var fechaNacimiento: LocalDate,
    var genero: String
)