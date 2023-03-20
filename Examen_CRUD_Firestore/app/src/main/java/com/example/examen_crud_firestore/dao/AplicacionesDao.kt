package com.example.examen_crud_firestore.dao

import com.example.examen_crud_firestore.model.Aplicacion

interface AplicacionesDao: GeneralDao<Aplicacion, Int> {

    fun getAllAplicaciones(onSuccess: (ArrayList<Aplicacion>) -> Unit)
}