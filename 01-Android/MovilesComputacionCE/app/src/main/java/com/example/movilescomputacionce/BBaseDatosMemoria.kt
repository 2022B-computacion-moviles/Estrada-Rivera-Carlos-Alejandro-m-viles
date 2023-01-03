package com.example.movilescomputacionce

class BBaseDatosMemoria {
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador("Carlos", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Alex", "b@b.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Camila", "c@c.com")
                )
        }
    }
}