package com.example.examen_crud_firestore.firebase

import com.example.examen_crud_firestore.dao.PlayStoreDao
import com.example.examen_crud_firestore.dao.UsersDao
import com.example.examen_crud_firestore.dao.AplicacionesDao

class FBPlayStoreDao: PlayStoreDao(){
    override fun getAplicacionDao(): AplicacionesDao {
        return FBAplicacionDao()
    }

    override fun getUserDao(): UsersDao {
        return FBUserDao()
    }
}