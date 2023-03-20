package com.example.examen_crud_firestore
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.examen_crud_firestore.dao.PlayStoreDao
import com.example.examen_crud_firestore.model.User
import java.time.LocalDate

class UserActivity : AppCompatActivity() {

    private var selectedUserId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val idUser = findViewById<TextView>(R.id.tv_editarUser)
        val idAplicacion = findViewById<TextView>(R.id.tv_aplicacionUserEdit)

        val nombrePlainText = findViewById<EditText>(R.id.input_nombreUserEdit)
        val apellidoPlainText = findViewById<EditText>(R.id.input_apellidoUserEdit)
        val correoPlainText = findViewById<EditText>(R.id.input_correoUserEdit)
        val generoPlainText = findViewById<EditText>(R.id.input_GeneroUserEdit)
        val fechaNacimientoPlainText = findViewById<EditText>(R.id.input_fechaNacimientoEdit)

        val btn_edit_user = findViewById<Button>(R.id.btn_edit_user)

        var selectedComponent: User? = null
        selectedUserId = intent.getIntExtra("selectedUserId", 0)

        // Setting component data when it is ready
        PlayStoreDao.playstore.getUserDao().read(
            selectedUserId!!,
            onSuccess = { component ->
                selectedComponent = component

                idUser.setText(selectedComponent!!.id.toString())
                idAplicacion.setText(selectedComponent!!.idAplicacion.toString())

                nombrePlainText.setText(selectedComponent!!.nombre)
                apellidoPlainText.setText(selectedComponent!!.apellido)
                correoPlainText.setText(selectedComponent!!.correo)
                generoPlainText.setText(selectedComponent!!.genero)
                fechaNacimientoPlainText.setText(selectedComponent!!.fechaNacimiento.toString())
            }
        )

        btn_edit_user.setOnClickListener {
                openEditionDialog(
                    User(
                        selectedUserId!!,
                        selectedComponent!!.idAplicacion,
                        nombrePlainText.text.toString(),
                        apellidoPlainText.text.toString(),
                        correoPlainText.text.toString(),
                        LocalDate.parse(fechaNacimientoPlainText.text.toString()),
                        generoPlainText.text.toString()
                    ),
                    selectedComponent!!.idAplicacion
                )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun openEditionDialog(editedComponent: User, selectedAplicacionId: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Edit")
        builder.setMessage("Are You Sure?")

        builder.setPositiveButton("Acept") { _, _ ->
            PlayStoreDao.playstore.getUserDao().update(editedComponent)
            Toast.makeText(this, "User has been modified", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CRUDUser::class.java)
            intent.putExtra("selectedAplicacionId", selectedAplicacionId)
            startActivity(intent)
        }
        builder.setNegativeButton("Cancel") { _, _ -> }
        val dialog = builder.create()
        dialog.show()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.mm_eliminarUser -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun openDeleteDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("Are you sure?")

        builder.setPositiveButton("Acept") { _, _ ->
            PlayStoreDao.playstore.getUserDao().delete(
                selectedUserId!!,
                onSuccess = {
                    val intent = Intent(this, CRUDUser::class.java)
                    startActivity(intent)
                }
            )
            Toast.makeText(this, "User has been removed", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("Cancel") { _, _ -> }

        val dialog = builder.create()
        dialog.show()
    }
}