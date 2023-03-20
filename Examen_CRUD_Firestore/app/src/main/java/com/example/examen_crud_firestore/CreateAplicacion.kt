package com.example.examen_crud_firestore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.examen_crud_firestore.dao.PlayStoreDao
import com.example.examen_crud_firestore.model.Aplicacion
import java.time.LocalDate

class CreateAplicacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_aplicacion)

        val nombre = findViewById<EditText>(R.id.input_nombreAplicacion)
        val descripcion = findViewById<EditText>(R.id.input_descripcionApp)
        val version = findViewById<EditText>(R.id.input_versionApp)
        val fechalanzamiento = findViewById<EditText>(R.id.input_fecha_lanzamiento)

        val btn_guardar_app = findViewById<Button>(R.id.btn_guardarAplicacion)

        btn_guardar_app.setOnClickListener {
            PlayStoreDao.playstore.getAplicacionDao().getRandomCode(
                onSuccess = { code ->
                        openCreationDialog(
                            Aplicacion(
                                code,
                                nombre.text.toString(),
                                descripcion.text.toString(),
                                version.text.toString(),
                                LocalDate.parse(fechalanzamiento.text.toString())
                            )
                        )
                }
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun openCreationDialog(newAplicacion: Aplicacion) {
        PlayStoreDao.playstore.getAplicacionDao().create(newAplicacion)
        Toast.makeText(this, "Médico Guardado", Toast.LENGTH_SHORT).show()
        openActivity(CRUDAplicacion::class.java)

    }

    private fun openActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
