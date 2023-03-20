package com.example.examen_crud_firestore.dao;


import com.example.examen_crud_firestore.firebase.FBPlayStoreDao;

abstract class PlayStoreDao {

    companion object {
        var playstore: PlayStoreDao = FBPlayStoreDao()
    }

    abstract fun getAplicacionDao(): AplicacionesDao
    abstract fun getUserDao(): UsersDao
}