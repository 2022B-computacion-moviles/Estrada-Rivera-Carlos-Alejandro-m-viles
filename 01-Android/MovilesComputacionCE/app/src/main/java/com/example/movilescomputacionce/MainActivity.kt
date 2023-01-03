package com.example.movilescomputacionce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Listener

        val Btn_Ciclo_Vida = findViewById<Button>(R.id.btn_ciclo_vida)
        Btn_Ciclo_Vida
            .setOnClickListener{
                IrActividad(ACicloVida::class.java)
            }
        val Btn_ir_list_View = findViewById<Button>(R.id.btn_ir_list_view)
        Btn_Ciclo_Vida
            .setOnClickListener{
                IrActividad(BListView::class.java)
            }
    }

    fun IrActividad(
        clase: Class<*>
    ){
        val intent = Intent (this, clase)
        startActivity(intent)
    }
}