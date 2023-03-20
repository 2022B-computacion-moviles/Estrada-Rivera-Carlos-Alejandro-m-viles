package com.example.examen_crud_firestore.model

import java.time.LocalDate

data class Aplicacion (
    var id: Int,
    var nombre: String,
    var version: String,
    var descripcion: String,
    var fecha_lanzamiento: LocalDate

)
