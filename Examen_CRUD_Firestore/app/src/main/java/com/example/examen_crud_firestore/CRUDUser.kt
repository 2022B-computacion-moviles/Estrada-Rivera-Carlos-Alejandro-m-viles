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
import com.example.examen_crud_firestore.model.User

class CRUDUser : AppCompatActivity() {

    private var selectedUserId: Int? = null
    private var selectedAplicacionId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cruduser)

        selectedAplicacionId = intent.getIntExtra("selectedAplicacionId", 0)

        val componentRecyclerView = findViewById<RecyclerView>(R.id.rv_users)
        val aplicacionIdTextView = findViewById<TextView>(R.id.tv_idAplicacionUser)
        val aplicacionNombreTextView = findViewById<TextView>(R.id.tv_nombreAplicacionUser)
        val btnCrearUser = findViewById<Button>(R.id.btn_crearUser)

        // Setting component device code when it is ready
        PlayStoreDao.playstore.getAplicacionDao().read(
            selectedAplicacionId!!,
            onSuccess = { device ->
                aplicacionIdTextView.text = device.id.toString()
                aplicacionNombreTextView.text = device.nombre
            }
        )

        // Setting the Recycler View when the data is ready
        PlayStoreDao.playstore.getUserDao().getUsersPorAplicacion(
            selectedAplicacionId!!,
            onSuccess = { components ->
                initializeRecyclerView(components, componentRecyclerView)
                registerForContextMenu(componentRecyclerView)
            }
        )

        btnCrearUser.setOnClickListener {
            val intent = Intent(this, CreateUser::class.java)
            intent.putExtra("selectedAplicacionId", selectedAplicacionId)
            startActivity(intent)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mm_editarUser -> {
                val intent = Intent(this, UserActivity::class.java)
                intent.putExtra("selectedUserId", selectedUserId)
                startActivity(intent)
                return true
            }
            R.id.mm_eliminarUser -> {
                openDeleteDialog()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    fun setSelectedComponentCode(UserId: Int) {
        selectedUserId = UserId
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun openDeleteDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("Are you Sure?")

        builder.setPositiveButton("Acept") { _, _ ->
            PlayStoreDao.playstore.getUserDao().delete(
                selectedUserId!!,
                onSuccess = {
                    PlayStoreDao.playstore.getUserDao().getUsersPorAplicacion(
                        selectedAplicacionId!!,
                        onSuccess = { components ->
                            initializeRecyclerView(components, findViewById(R.id.rv_users))
                        }
                    )
                }
            )
            Toast.makeText(this, "User has been removed", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("No") { _, _ -> }

        val dialog = builder.create()
        dialog.show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initializeRecyclerView(
        list: ArrayList<User>,
        recyclerView: RecyclerView
    ) {
        val adapter = UserAdapter(this, list)

        recyclerView.adapter = adapter
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adapter.notifyDataSetChanged()
    }
}