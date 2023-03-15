package com.example.ultdietf.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DbDiet(
    private var idDiet: Int,
    private var typeDiet: String
) {
    init {
        idDiet
        typeDiet
    }

    fun setidDiet(idDiet: Int) {
        this.idDiet = idDiet
    }

    fun settypeDiet(typeDiet: String) {
        this.typeDiet = typeDiet
    }

    fun getidDiet(): Int {
        return idDiet
    }

    fun gettypeDiet(): String {
        return typeDiet
    }

    fun inserDiet(context: Context): Long {
        val dbHelper: DbHelper = DbHelper(context)
        val db: SQLiteDatabase = dbHelper.writableDatabase

        val values: ContentValues = ContentValues()
        values.put("tipo_dieta", this.typeDiet)

        return db.insert("t_dieta", null, values)
    }

    fun getTypeOfDiet(){

    }
}