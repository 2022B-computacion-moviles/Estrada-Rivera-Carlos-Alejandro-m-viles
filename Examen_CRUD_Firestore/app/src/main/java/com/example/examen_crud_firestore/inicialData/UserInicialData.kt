package com.example.examen_crud_firestore.inicialData

import com.example.examen_crud_firestore.model.User
import java.time.LocalDate

class UserInicialData {

    companion object {
        var usersInitData = ArrayList<User>()

        init {
                usersInitData.add(
                    User(
                        1, 1,"Carlos","Estrada", "carlos.test@gmail.com", LocalDate.parse("1999-08-18"), "M"
                    )
                )

                usersInitData.add(
                    User(
                        2, 1,"Patricio","Estrada", "patricio.test@gmail.com", LocalDate.parse("1994-08-21"),"M"
                    )
                )
        }
    }
}