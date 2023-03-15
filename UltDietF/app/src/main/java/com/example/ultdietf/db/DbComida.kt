package com.example.ultdietf.db

class DbComida(
    private var idComida: Int,
    private var idDieta: Int,
    private var descripcion: String,
    private var horario: String
) {
    init {
        idComida
        idDieta
        descripcion
        horario
    }

    fun setidComida(idComida: Int) {
        this.idComida = idComida
    }

    fun setidDieta(idDieta: Int) {
        this.idDieta = idDieta
    }

    fun setdescripcion(descripcion: String) {
        this.descripcion = descripcion
    }

    fun sethorario(horario: String) {
        this.horario = horario
    }

    fun getidComida(): Int {
        return idComida
    }

    fun getidDieta(): Int {
        return idDieta
    }

    fun getdescripcion(): String {
        return descripcion
    }

    fun gethorario(): String {
        return horario
    }
}