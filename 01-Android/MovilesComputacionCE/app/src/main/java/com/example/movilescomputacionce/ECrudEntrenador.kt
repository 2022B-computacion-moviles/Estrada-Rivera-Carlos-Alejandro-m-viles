package com.example.movilescomputacionce

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ECrudEntrenador : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecrud_entrenador)
        val botonCrearBDD = findViewById<Button>(R.id.btn_crear_bdd)
        botonCrearBDD
            .setOnClickListener(){
                val nombre = findViewById<EditText>(R.id.input_nombre)
                val descripcion = findViewById<EditText>(R.id.input_descripcion)
                EBaseDeDatos.TablaEntrenador!!.crearEntrenador(
                    nombre.text.toString(),
                    descripcion.text.toString()
                )
            }
        val botonBuscarBDD = findViewById<Button>(R.id.btn_buscar_bdd)
        botonBuscarBDD
            .setOnClickListener(){
                val id = findViewById<EditText>(R.id.input_id)
                val nombre = findViewById<EditText>(R.id.input_nombre)
                val descripcion = findViewById<EditText>(R.id.input_descripcion)
                val entrenador = EBaseDeDatos.TablaEntrenador!!.consultarEntrenadorxId(
                    id.text.toString().toInt()
                )
                id.setText(entrenador.id.toString())
                nombre.setText(entrenador.nombre)
                descripcion.setText(entrenador.descripcion)
            }
        val botonActulizarBDD = findViewById<Button>(R.id.btn_buscar_bdd)
        botonActulizarBDD
            .setOnClickListener(){
                val id = findViewById<EditText>(R.id.input_id)
                val nombre = findViewById<EditText>(R.id.input_nombre)
                val descripcion = findViewById<EditText>(R.id.input_descripcion)
                val entrenador = EBaseDeDatos.TablaEntrenador!!.actualizarEntrenadorFormulario(
                    id.text.toString().toInt(),
                    nombre.text.toString(),
                    descripcion.text.toString()
                )
            }
        val botonEliminarBDD = findViewById<Button>(R.id.btn_buscar_bdd)
        botonEliminarBDD
            .setOnClickListener(){
                val id = findViewById<EditText>(R.id.input_id)
                val entrenador = EBaseDeDatos.TablaEntrenador!!.eliminarEntrenadorFormulario(
                    id.text.toString().toInt()
                )
            }
    }
}