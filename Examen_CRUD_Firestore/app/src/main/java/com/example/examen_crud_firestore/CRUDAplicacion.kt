package com.example.examen_crud_firestore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_crud_firestore.dao.PlayStoreDao
import com.example.examen_crud_firestore.model.Aplicacion
import com.example.examen_crud_firestore.inicialData.AplicacionInicialData
import com.example.examen_crud_firestore.inicialData.UserInicialData

class CRUDAplicacion : AppCompatActivity() {
    private var selectedAplicacionId: Int? = null
    var aplicacionesList = ArrayList<Aplicacion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aplicacionesRv = findViewById<RecyclerView>(R.id.rv_aplicaciones) as RecyclerView
        val btnCrear = findViewById<Button>(R.id.btn_crearAplicacion)

        PlayStoreDao.playstore.getAplicacionDao().getAllAplicaciones(
            onSuccess = { aplicaciones ->
                aplicacionesList = aplicaciones
                if(aplicacionesList.isEmpty()){
                    initData()
                    openActivity(CRUDAplicacion::class.java)

                }
                initializeRecyclerView(aplicacionesList, aplicacionesRv)
                registerForContextMenu(aplicacionesRv)
            }
        )
        btnCrear.setOnClickListener {
            openActivity(CreateAplicacion::class.java)
        }
    }

    private fun initData() {
        for (aplicacion in AplicacionInicialData.aplicacionesInitData) {
            PlayStoreDao.playstore.getAplicacionDao().create(aplicacion)
        }

        for (user in UserInicialData.usersInitData) {
            PlayStoreDao.playstore.getUserDao().create(user)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mm_editarAplicacion -> {
                val intent = Intent(this, AplicacionActivity::class.java)
                intent.putExtra("selectedAplicacionId", selectedAplicacionId)
                startActivity(intent)
                return true
            }
            R.id.mm_eliminarAplicacion -> {
                openDeleteDialog()
                return true
            }
            R.id.mm_verusers -> {
                val intent = Intent(this, CRUDUser::class.java)
                intent.putExtra("selectedAplicacionId", selectedAplicacionId)
                startActivity(intent)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    fun setSelectedAplicacionId(aplicacionId: Int) {
        selectedAplicacionId = aplicacionId
    }

    private fun openDeleteDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("Are you sure?")

        builder.setPositiveButton("Acept") { _, _ ->
            PlayStoreDao.playstore.getAplicacionDao().delete(
                selectedAplicacionId!!,
                onSuccess = {
                    PlayStoreDao.playstore.getAplicacionDao().getAllAplicaciones(
                        onSuccess = { aplicaciones ->
                            initializeRecyclerView(aplicaciones, findViewById(R.id.rv_aplicaciones))
                        }
                    )
                }
            )
            Toast.makeText(this, "register has been deleted", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel") { _, _ -> }

        val dialog = builder.create()
        dialog.show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initializeRecyclerView(
        list: ArrayList<Aplicacion>,
        recyclerView: RecyclerView
    ) {
        val adapter = AplicacionAdapter(this, list)

        recyclerView.adapter = adapter
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adapter.notifyDataSetChanged()
    }

    private fun openActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}