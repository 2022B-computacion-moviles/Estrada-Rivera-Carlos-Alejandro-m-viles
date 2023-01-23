package com.example.movilescomputacionce

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelperEntrenador(
    contexto: Context?, // THIS
): SQLiteOpenHelper(
    contexto,
    "moviles", // nombres BDD
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaEntrenador =
            """
                CREATE TABLE ENTRENADOR(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre VARCHAR(50),
                descripcion VARCHAR(50)
                )
            """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaEntrenador)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) { }

    fun crearEntrenador(
        nombre: String,
        descripcion: String
    ): Boolean {
        val baseDatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre", nombre)
        valoresAGuardar.put("descripcion", descripcion)
        val resultadoGuardar = baseDatosEscritura
            .insert(
                "ENTRENADOR", //Nombre tabla
                null,
                valoresAGuardar //valores
            )
        baseDatosEscritura.close()
        return if (resultadoGuardar.toInt() == -1) false else true
    }
    //Eleminar Entrenador
    fun eliminarEntrenadorFormulario(
        id:Int
    ): Boolean {
        val conexionescritura = writableDatabase

        val resultadoEliminación = conexionescritura
            .delete(
                "ENTRENADOR", //Nombre tabla
                "id?",
                arrayOf(
                    id.toString()
                )
            )
        conexionescritura.close()
        return if (resultadoEliminación.toInt() == -1) false else true
    }

    //Actualizar Entrenador

    fun actualizarEntrenadorFormulario(
        idActulizar:Int,
        nombre: String,
        descripcion: String
    ): Boolean {
        val valoresAActulizar = ContentValues()
        valoresAActulizar.put("nombre", nombre)
        valoresAActulizar.put("descripcion", descripcion)
        val conexionescritura = writableDatabase

        val resultadoActualización = conexionescritura
            .update(
                "ENTRENADOR", //Nombre tabla
                valoresAActulizar,
                "id?",
                arrayOf(
                    idActulizar.toString()
                )
            )
        conexionescritura.close()
        return if (resultadoActualización.toInt() == -1) false else true
    }

    fun consultarEntrenadorxId(id: Int): BEntrenador
    {
        val conexionLectura = readableDatabase
        val ScriptConsultaUsuario = "SELECT * FROM WHERE ID = ?"
        val resultadoConsultaLectura = conexionLectura.rawQuery(
            ScriptConsultaUsuario,
            arrayOf(
                id.toString()
            )
        )
        val existeUsuario = resultadoConsultaLectura.moveToFirst()
        val usuarioEncontrado = BEntrenador(0,"","")
        // LOGICA DE LA CONSULTA
        do{
            val id = resultadoConsultaLectura.getInt(0)
            val nombre = resultadoConsultaLectura.getString(1)
            val descripcion =
                resultadoConsultaLectura.getString(2)
            if(id != null){
                usuarioEncontrado.id = id
                usuarioEncontrado.nombre = nombre
                usuarioEncontrado.descripcion = descripcion
            }
        }while(resultadoConsultaLectura.moveToNext())
        resultadoConsultaLectura.close()
        conexionLectura.close()
        return usuarioEncontrado
    }

}