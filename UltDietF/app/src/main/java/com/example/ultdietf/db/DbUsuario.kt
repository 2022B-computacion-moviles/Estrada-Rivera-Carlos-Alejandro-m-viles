package com.example.ultdietf.db

class DbUsuario(
    //Atributos
    private var idUsuario: Int,
    private var idDieta: Int,
    private var email: String,
    private var nombre: String,
    private var password: String,
    private var altura: String,
    private var pesoActual: String,
    private var pesoObjetivo: String
) {
    init {
        idUsuario
        idDieta
        email
        nombre
        password
        altura
        pesoActual
        pesoObjetivo
    }

    fun setidUsuario(idUsuario: Int) {
        this.idUsuario = idUsuario
    }

    fun setidDieta(idDieta: Int) {
        this.idDieta = idDieta
    }

    fun setemail(email: String) {
        this.email = email
    }

    fun setnombre(nombre: String) {
        this.nombre = nombre
    }

    fun setpassword(password: String) {
        this.password = password
    }

    fun setaltura(altura: String) {
        this.altura = altura
    }

    fun setpesoActual(pesoActual: String) {
        this.pesoActual = pesoActual
    }

    fun setpesoObjetivo(pesoObjetivo: String) {
        this.pesoObjetivo = pesoObjetivo
    }

    fun getidUsuario(): Int {
        return idUsuario
    }

    fun getidDieta(): Int {
        return idDieta
    }

    fun getemail(): String {
        return email
    }

    fun getnombre(): String {
        return nombre
    }

    fun getpassword(): String {
        return password
    }

    fun getaltura(): String {
        return altura
    }

    fun getpesoActual(): String {
        return pesoActual
    }

    fun getpesoObjetivo(): String {
        return pesoObjetivo
    }
}