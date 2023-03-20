package com.example.examen_crud_firestore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.examen_crud_firestore.dao.PlayStoreDao
import com.example.examen_crud_firestore.model.User

import java.time.LocalDate

class CreateUser : AppCompatActivity() {

    private var selectedAplicacionId: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        selectedAplicacionId = intent.getIntExtra("selectedAplicacionId", 0)

        val idAplicacionUser = findViewById<TextView>(R.id.tv_aplicacionUser)

        val nombre = findViewById<EditText>(R.id.input_nombreUser)
        val apellido = findViewById<EditText>(R.id.input_apellidoUser)
        val fechaNacimiento = findViewById<EditText>(R.id.input_fechaNacimiento)
        val correo = findViewById<EditText>(R.id.input_correoUser)
        val genero = findViewById<EditText>(R.id.input_correoUser)

        val crearUser = findViewById<Button>(R.id.btn_guardarUser)

        idAplicacionUser.setText(selectedAplicacionId.toString())

        crearUser.setOnClickListener {
            PlayStoreDao.playstore.getUserDao().getRandomCode(
                onSuccess = { code ->
                        openCreationDialog(
                            User(
                                code,
                                selectedAplicacionId!!,
                                nombre.text.toString(),
                                apellido.text.toString(),
                                correo.text.toString(),
                                LocalDate.parse(fechaNacimiento.text.toString()),
                                genero.text.toString()
                            ),
                            selectedAplicacionId!!
                        )
                }
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun openCreationDialog(newUser: User, selectedMedicoId: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Save")
        builder.setMessage("Are you Sure?")

        builder.setPositiveButton("Acept") { _, _ ->
            PlayStoreDao.playstore.getUserDao().create(newUser)
            Toast.makeText(this, "User has been saved", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CRUDUser::class.java)
            intent.putExtra("selectedAplicacionId", selectedAplicacionId)
            startActivity(intent)
        }

        builder.setNegativeButton("No") { _, _ -> }
        val dialog = builder.create()
        dialog.show()
    }
}