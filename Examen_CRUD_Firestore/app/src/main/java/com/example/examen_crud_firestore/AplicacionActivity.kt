package com.example.examen_crud_firestore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.examen_crud_firestore.dao.PlayStoreDao
import com.example.examen_crud_firestore.model.Aplicacion
import java.time.LocalDate

class AplicacionActivity : AppCompatActivity() {

    var selectedAplicacionID : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aplicacion)

        val idAplicacion = findViewById<TextView>(R.id.tv_editarAplicacion)
        val nombre = findViewById<EditText>(R.id.input_nombreAplicacionEdit)
        val descripcion = findViewById<EditText>(R.id.input_descripcionExpEdit)
        val version = findViewById<EditText>(R.id.input_VersionAplicacionEdit)
        val fecha_lanzamiento = findViewById<EditText>(R.id.input_fechaLanzamientoAppEdit)

        val BtnEditarAplicación = findViewById<Button>(R.id.btn_editarAplicacion)

        selectedAplicacionID = intent.getIntExtra("selectedAplicacionId", 0)

        PlayStoreDao.playstore.getAplicacionDao().read(
            selectedAplicacionID!!,
            onSuccess = { device ->
                idAplicacion.setText(device.id.toString())
                nombre.setText(device.nombre)
                descripcion.setText(device.descripcion.toString())
                version.setText(device.version.toString())
                fecha_lanzamiento.setText(device.fecha_lanzamiento.toString())
            }
        )

        BtnEditarAplicación.setOnClickListener {
                openEditionDialog(
                    Aplicacion(
                        selectedAplicacionID!!,
                        nombre.text.toString(),
                        version.text.toString(),
                        descripcion.text.toString(),
                        LocalDate.parse(fecha_lanzamiento.text.toString())
                    )
                )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun openEditionDialog(editedApp: Aplicacion) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Edit")
        builder.setMessage("Are you sure edit this register")

        builder.setPositiveButton("Acept") { _, _ ->
            PlayStoreDao.playstore.getAplicacionDao().update(editedApp)
            Toast.makeText(this, "App has been modified", Toast.LENGTH_SHORT).show()
            openActivity(CRUDAplicacion::class.java)
        }
        builder.setNegativeButton("Cancel") { _, _ -> }
        val dialog = builder.create()
        dialog.show()
    }

    //go to activity
    private fun openActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuaplicacion, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.mm_eliminarAplicacion -> {
                openDeleteDialog()
                return true
            }
            R.id.mm_verusers -> {
                val intent = Intent(this, CRUDUser::class.java)
                intent.putExtra("selectedAplicacionId", selectedAplicacionID)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openDeleteDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("Are you sure?")

        builder.setPositiveButton("Acept") { _, _ ->
            PlayStoreDao.playstore.getAplicacionDao().delete(
                selectedAplicacionID!!,
                onSuccess = {
                    val intent = Intent(this, CRUDAplicacion::class.java)
                    startActivity(intent)
                }
            )
            Toast.makeText(this, "register has been removed", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }

        val dialog = builder.create()
        dialog.show()
    }


}