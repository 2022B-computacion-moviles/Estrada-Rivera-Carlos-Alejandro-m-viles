package com.example.ultdietf.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DbUser(
    //Atributos
    private var idUser: Int,
    private var idDiet: Int,
    private var email: String,
    private var name: String,
    private var password: String,
    private var height: String,
    private var actualWeight: String,
    private var targetWeight: String
) {
    init {
        idUser
        idDiet
        email
        name
        password
        height
        actualWeight
        targetWeight
    }

    companion object {
        var chooseGoal: Int = 0
        var userAux = DbUser(0,0,"","", "", "", "", "")
    }

    fun setidUser(idUser: Int) {
        this.idUser = idUser
    }

    fun setidDiet(idDiet: Int) {
        this.idDiet = idDiet
    }

    fun setemail(email: String) {
        this.email = email
    }

    fun setname(name: String) {
        this.name = name
    }

    fun setpassword(password: String) {
        this.password = password
    }

    fun setheight(height: String) {
        this.height = height
    }

    fun setactualWeight(actualWeight: String) {
        this.actualWeight = actualWeight
    }

    fun settargetWeight(targetWeight: String) {
        this.targetWeight = targetWeight
    }

    fun getidUser(): Int {
        return idUser
    }

    fun getidDiet(): Int {
        return idDiet
    }

    fun getemail(): String {
        return email
    }

    fun getname(): String {
        return name
    }

    fun getpassword(): String {
        return password
    }

    fun getheight(): String {
        return height
    }

    fun getactualWeight(): String {
        return actualWeight
    }

    fun gettargetWeight(): String {
        return targetWeight
    }

    fun insertUser(context: Context): Long {
        val dbHelper: DbHelper = DbHelper(context)
        val db: SQLiteDatabase = dbHelper.writableDatabase

        val values: ContentValues = ContentValues()
        values.put("email_usuario", this.email)
        values.put("nombre_usuario", this.name)
        values.put("password_usuario", this.password)
        values.put("altura_usuario", this.height)
        values.put("pesoact_usuario", this.actualWeight)
        values.put("pesoobj_usuario", this.targetWeight)
        values.put("id_dieta", this.idDiet)

        return db.insert("t_usuario", null, values)
    }

    fun verifyUserAndPassword(context: Context, email: String, password: String): Boolean {
        var answerUserAndPassword = false
        val dbHelper: DbHelper = DbHelper(context)
        val db: SQLiteDatabase = dbHelper.writableDatabase

        var userCursor: Cursor? = null

        userCursor = db.rawQuery("SELECT email_usuario, password_usuario FROM t_usuario", null)

        if (userCursor.moveToFirst()) {
            do {
                if (userCursor.getString(0).equals(email) && userCursor.getString(1)
                        .equals(password)
                ) {
                    answerUserAndPassword = true
                    break
                }
            } while (userCursor.moveToNext())
        }
        return answerUserAndPassword
    }
}