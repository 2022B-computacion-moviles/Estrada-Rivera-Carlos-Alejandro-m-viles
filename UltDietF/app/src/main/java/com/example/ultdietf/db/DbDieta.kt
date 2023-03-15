package com.example.ultdietf.db

class DbDieta(
    private var idDieta: Int,
    private var tipoDieta: String
) {
    init {
        idDieta
        tipoDieta
    }

    fun setidDieta(idDieta: Int) {
        this.idDieta = idDieta
    }

    fun settipoDieta(tipoDieta: String) {
        this.tipoDieta = tipoDieta
    }

    fun getidDieta(): Int {
        return idDieta
    }

    fun gettipoDieta(): String {
        return tipoDieta
    }
}