package com.example.examen_crud_firestore.inicialData

import com.example.examen_crud_firestore.model.Aplicacion
import java.time.LocalDate

class AplicacionInicialData {

    companion object {
        var aplicacionesInitData = ArrayList<Aplicacion>()
        init {
                aplicacionesInitData.add(
                    Aplicacion(
                        1, "Facebook",  "7.8.9","RedSocial", LocalDate.parse("2010-10-11")
                    )
                )

                aplicacionesInitData.add(
                    Aplicacion(
                        1, "Twitter",  "3.8.9","RedSocial", LocalDate.parse("2008-05-05")
                    )
                )
        }
    }
}