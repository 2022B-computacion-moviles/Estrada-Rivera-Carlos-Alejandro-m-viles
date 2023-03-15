package com.example.ultdietf

import android.app.Activity
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.ultdietf.db.DbDiet
import com.example.ultdietf.db.DbHelper
import com.example.ultdietf.db.DbUser

class outcomming_activity : Activity() {
    private var _bg__outcomming_ek2: View? = null
    private var logomovlies_1: ImageView? = null
    private var eiliv_aceron_nniwipdxbpg_unsplash_1: ImageView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.outcomming)
        _bg__outcomming_ek2 = findViewById(R.id._bg__outcomming_ek2) as View
        logomovlies_1 = findViewById<View>(R.id.logomovlies_1) as ImageView
        eiliv_aceron_nniwipdxbpg_unsplash_1 =
            findViewById<View>(R.id.eiliv_aceron_nniwipdxbpg_unsplash_1) as ImageView


        //custom code goes here
        Handler().postDelayed({
            val intent = Intent(this@outcomming_activity, SIGUIENTE_ACTIVIDAD)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }, TIEMPO_DEMOSTRACION.toLong())

        // Create DB
        val dbHelper: DbHelper = DbHelper(this)
        val db: SQLiteDatabase = dbHelper.writableDatabase
        if (db != null) {
            //Toast.makeText(this, "DATABASE CREATED", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "ERROR WHILE CREATING DATABASE", Toast.LENGTH_LONG).show()
        }
        // End create DB

        // Insert Diet
        val diet1 = DbDiet(1, "Lose weight")
        val diet2 = DbDiet(2, "Gain weight")
        val diet3 = DbDiet(3, "Stain healthy")
        diet1.inserDiet(this)
        diet2.inserDiet(this)
        diet3.inserDiet(this)
        // End insert diet

        // Insert User
        val user1 = DbUser(1, 1,"alexanderguillin1999@gmail.com", "Alexander Guillin", "admin", "1.70", "60Kg", "55Kg")
        val user2 = DbUser(2, 1,"carlos.estrada@epn.edu.ec", "Carlos Estrada", "admin", "1.72", "60Kg", "55Kg")
        user1.insertUser(this)
        user2.insertUser(this)
        // End insert user
    }

    companion object {
        private const val TIEMPO_DEMOSTRACION = 3000 // 2 segundos
        private val SIGUIENTE_ACTIVIDAD: Class<*> = outcomming2_activity::class.java
    }
}