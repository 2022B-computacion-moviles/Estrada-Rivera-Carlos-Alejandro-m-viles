package com.example.movilescomputacionce

class BBaseDatosMemoria {
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador(1,"Carlos", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2,"Alex", "b@b.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3,"Camila", "c@c.com")
                )
        }
    }
}