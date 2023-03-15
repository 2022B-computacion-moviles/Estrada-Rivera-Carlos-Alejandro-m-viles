package com.example.ultdietf

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class configuraci_n_incial_2_activity : Activity() {
    private var _bg__configuraci_n_incial_2_ek2: View? = null
    private var left_3: ImageView? = null
    private var what_is_your_height: TextView? = null
    private var what_is_your_weight: TextView? = null
    private var what_is_your_target_weight: TextView? = null
    private var rectangle_9: ImageView? = null
    private var rectangle_10: View? = null
    private var rectangle_11: ImageView? = null
    private var _170: TextView? = null
    private var rectangle_12: View? = null
    private var siguiente: TextView? = null
    private var _70: EditText? = null
    private var _65: EditText? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.configuraci_n_incial_2)
        _bg__configuraci_n_incial_2_ek2 =
            findViewById<View>(R.id._bg__configuraci_n_incial_2_ek2) as View
        left_3 = findViewById<View>(R.id.left_3) as ImageView
        what_is_your_height = findViewById<View>(R.id.what_is_your_height) as TextView
        what_is_your_weight = findViewById<View>(R.id.what_is_your_weight) as TextView
        what_is_your_target_weight = findViewById<View>(R.id.what_is_your_target_weight) as TextView
        rectangle_9 = findViewById<View>(R.id.rectangle_9) as ImageView
        rectangle_10 = findViewById<View>(R.id.rectangle_10) as View
        rectangle_11 = findViewById<View>(R.id.rectangle_11) as ImageView
        _170 = findViewById<View>(R.id._170) as TextView
        rectangle_12 = findViewById<View>(R.id.rectangle_12) as View
        siguiente = findViewById<View>(R.id.siguiente) as TextView
        //_70 = findViewById<View>(R.id._70) as EditText
        //_65 = findViewById<View>(R.id._65) as EditText


        //custom code goes here
    }
}