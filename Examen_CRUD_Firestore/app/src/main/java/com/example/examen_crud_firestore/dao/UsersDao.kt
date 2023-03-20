package com.example.examen_crud_firestore.dao

import com.example.examen_crud_firestore.model.User
interface UsersDao: GeneralDao<User, Int>{
    fun getUsersPorAplicacion(aplicacionId: Int,onSuccess: (ArrayList<User>) -> Unit)
}