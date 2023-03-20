package com.example.examen_crud_firestore.firebase

import com.example.examen_crud_firestore.dao.PlayStoreDao
import com.example.examen_crud_firestore.dao.UsersDao
import com.example.examen_crud_firestore.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class FBUserDao: UsersDao {

    private val db = Firebase.firestore
    private val aplicacionesCollectionReference = db.collection("aplicacion")

    override fun getUsersPorAplicacion(aplicacionId: Int, onSuccess: (ArrayList<User>) -> Unit) {
        aplicacionesCollectionReference
            .document(aplicacionId.toString())
            .collection("user")
            .get()
            .addOnSuccessListener { documents ->
                val users = ArrayList<User>()

                for (document in documents) {
                        users.add(
                            User(
                                id = document.id.split("/").last().toInt(),
                                idAplicacion = aplicacionId,
                                nombre = document.getString("nombre")!!,
                                apellido = document.getString("apellido")!!,
                                correo = document.getString("correo")!!,
                                genero = document.getString("genero")!!,
                                fechaNacimiento = LocalDate.parse(document.getString("fechaNacimiento")!!)
                            )
                        )
                }
                onSuccess(users)
            }
    }

    override fun create(entity: User) {
        val user = hashMapOf(
            "nombre" to entity.nombre,
            "apellido" to entity.apellido,
            "correo" to entity.correo,
            "genero" to entity.genero,
            "fechaNacimiento" to  entity.fechaNacimiento.toString()
        )

        aplicacionesCollectionReference
            .document(entity.idAplicacion.toString())
            .collection("user")
            .document(entity.id.toString()).set(user)
    }

    override fun read(code: Int, onSuccess: (User) -> Unit) {
        PlayStoreDao.playstore.getAplicacionDao().getAllAplicaciones { documents ->
            for (document in documents) {
                val db = Firebase.firestore
                val userCollectionReference = db.collection(
                    "aplicacion/${document.id}/user"
                )

                userCollectionReference
                    .get()
                    .addOnSuccessListener { documentsUsers ->
                        for (documentUser in documentsUsers) {
                            if (documentUser.id.toInt() == code) {
                                    onSuccess(
                                        User(
                                            documentUser.id.toInt(),
                                            document.id,
                                            documentUser.getString("nombre")!!,
                                            documentUser.getString("apellido")!!,
                                            documentUser.getString("correo")!!,
                                            LocalDate.parse(documentUser.data!!["fechaNacimiento"].toString()),
                                            documentUser.getString("genero")!!

                                        )
                                    )
                            }
                        }
                    }
            }
        }
    }

    override fun update(entity: User) {
        val user = hashMapOf(
            "nombre" to entity.nombre,
            "fechaNacimiento" to  entity.fechaNacimiento.toString(),
            "apellido" to entity.apellido,
            "correo" to entity.correo,
            "genero" to entity.genero,
        )

        aplicacionesCollectionReference
            .document(entity.idAplicacion.toString())
            .collection("user")
            .document(entity.idAplicacion.toString()).set(user)
    }

    override fun delete(code: Int, onSuccess: (Unit) -> Unit) {
        PlayStoreDao.playstore.getAplicacionDao().getAllAplicaciones { documents ->
            for (document in documents) {
                val db = Firebase.firestore
                val UserCollectionReference = db.collection(
                    "aplicacion/${document.id}/user"
                )

                UserCollectionReference
                    .get()
                    .addOnSuccessListener { documentsUsers ->
                        for (documentUser in documentsUsers) {
                            if (documentUser.id.toInt() == code) {
                                val pacienteReference = UserCollectionReference
                                    .document(code.toString())

                                pacienteReference.delete().addOnSuccessListener {
                                    onSuccess(Unit)
                                }
                            }
                        }
                    }
            }
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