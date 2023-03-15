package com.example.ultdietf.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DbFood(
    private var idFood: Int,
    private var idDiet: Int,
    private var description: String,
    private var schedule: String
) {
    init {
        idFood
        idDiet
        description
        schedule
    }

    fun setidFood(idFood: Int) {
        this.idFood = idFood
    }

    fun setidDiet(idDiet: Int) {
        this.idDiet = idDiet
    }

    fun setdescription(description: String) {
        this.description = description
    }

    fun setschedule(schedule: String) {
        this.schedule = schedule
    }

    fun getidFood(): Int {
        return idFood
    }

    fun getidDiet(): Int {
        return idDiet
    }

    fun getdescription(): String {
        return description
    }

    fun getschedule(): String {
        return schedule
    }

    fun insertFood(context: Context): Long {
        val dbHelper: DbHelper = DbHelper(context)
        val db: SQLiteDatabase = dbHelper.writableDatabase

        val values: ContentValues = ContentValues()
        values.put("id_dieta", this.idDiet)
        values.put("descripcion_comida", this.description)
        values.put("horario_comida", this.schedule)

        return db.insert("t_usuario", null, values)
    }
}