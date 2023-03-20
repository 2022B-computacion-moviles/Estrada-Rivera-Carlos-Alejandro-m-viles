package com.example.examen_crud_firestore.firebase

import android.os.Build
import com.example.examen_crud_firestore.dao.AplicacionesDao
import com.example.examen_crud_firestore.model.Aplicacion
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class FBAplicacionDao: AplicacionesDao {

    private val db = Firebase.firestore
    private val aplicacionesCollectionReference = db.collection("aplicacion")

    override fun getAllAplicaciones(onSuccess: (ArrayList<Aplicacion>) -> Unit) {
        aplicacionesCollectionReference
            .get()
            .addOnSuccessListener { documents ->
                val aplicaciones = ArrayList<Aplicacion>()


                for (document in documents) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        aplicaciones.add(
                            Aplicacion(
                                id = document.id.split("/").last().toInt(),
                                nombre = document.getString("nombre")!!,
                                descripcion = document.getString("descripcion")!!,
                                version =  document.getString("version")!!,
                                fecha_lanzamiento = LocalDate.parse(document.getString("fecha_lanzamiento")!!)
                            )
                        )
                    }
                }
                onSuccess(aplicaciones)
            }
    }

    override fun create(entity: Aplicacion) {
        val aplicacion = hashMapOf(
            "nombre" to entity.nombre,
            "fechaNacimiento" to entity.fecha_lanzamiento.toString(),
            "descripcion" to entity.descripcion,
            "version" to entity.version
        )
        aplicacionesCollectionReference.document(entity.id.toString()).set(aplicacion)
    }

    override fun read(code: Int, onSuccess: (Aplicacion) -> Unit) {
        val aplicacionReference = aplicacionesCollectionReference.document(code.toString())

        aplicacionReference
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val aplicacion = Aplicacion(
                            code,
                            document.data!!["nombre"].toString(),
                            document.data!!["descripcion"].toString(),
                            document.data!!["version"].toString(),
                            LocalDate.parse(document.data!!["fecha_lanzamiento"].toString())
                        )
                    onSuccess(aplicacion)
                }
            }
    }

    override fun update(entity: Aplicacion) {
        val aplicacion = hashMapOf(
            "nombre" to entity.nombre,
            "fecha_lanzamiento" to entity.fecha_lanzamiento.toString(),
            "descripcion" to entity.descripcion,
            "version" to entity.version
        )
        aplicacionesCollectionReference.document(entity.id.toString()).set(aplicacion)
    }

    override fun delete(code: Int, onSuccess: (Unit) -> Unit) {
        val AplicacionReference = aplicacionesCollectionReference.document(code.toString())

        AplicacionReference.delete().addOnSuccessListener {
            onSuccess(Unit)
        }
    }

    override fun getRandomCode(onSuccess: (Int) -> Unit) {
        var id = Date().time.toInt()
        if(id<0){
            id*=-1
        }
        onSuccess(id)
    }
}