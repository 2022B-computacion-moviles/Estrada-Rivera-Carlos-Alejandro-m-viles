package com.example.ultdietf

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class perfil_activity : Activity() {
    private var _vince_veras_ajiqzdaud7a_unsplash_1: ImageView? = null
    private var left_6: ImageView? = null
    private var rectangle_20: View? = null
    private var line_2: View? = null
    private var line_3: View? = null
    private var rectangle_21: View? = null
    private var exit: TextView? = null
    private var person_name: TextView? = null
    private var line_1: View? = null
    private var my_goals: TextView? = null
    private var change_diet: TextView? = null
    private var recipe_book: TextView? = null
    private var whatsapp: ImageView? = null
    private var facebook: ImageView? = null
    private var instagram: ImageView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil)
        _vince_veras_ajiqzdaud7a_unsplash_1 =
            findViewById<View>(R.id._vince_veras_ajiqzdaud7a_unsplash_1) as ImageView
        left_6 = findViewById<View>(R.id.left_6) as ImageView
        rectangle_20 = findViewById<View>(R.id.rectangle_20) as View
        line_2 = findViewById<View>(R.id.line_2) as View
        line_3 = findViewById<View>(R.id.line_3) as View
        rectangle_21 = findViewById<View>(R.id.rectangle_21) as View
        exit = findViewById<View>(R.id.exit) as TextView
        person_name = findViewById<View>(R.id.person_name) as TextView
        line_1 = findViewById<View>(R.id.line_1) as View
        my_goals = findViewById<View>(R.id.my_goals) as TextView
        change_diet = findViewById<View>(R.id.change_diet) as TextView
        recipe_book = findViewById<View>(R.id.recipe_book) as TextView
        whatsapp = findViewById<View>(R.id.whatsapp) as ImageView
        facebook = findViewById<View>(R.id.facebook) as ImageView
        instagram = findViewById<View>(R.id.instagram) as ImageView
        _vince_veras_ajiqzdaud7a_unsplash_1!!.setOnClickListener {
            val nextScreen = Intent(applicationContext, perfil_activity::class.java)
            startActivity(nextScreen)
        }


        //custom code goes here
    }
}