package com.example.ultdietf

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class registro_activity : Activity() {
    private var all_ready__: TextView? = null
    private var left_4: ImageView? = null
    private var rectangle_13: View? = null
    private var rectangle_14: View? = null
    private var your_email: TextView? = null
    private var your_name: TextView? = null
    private var your_password: TextView? = null
    private var repeat_password: TextView? = null
    private var rectangle_15: View? = null
    private var rectangle_16: View? = null
    private var rectangle_17: View? = null
    private var sign_up: TextView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)
        all_ready__ = findViewById<View>(R.id.all_ready__) as TextView
        left_4 = findViewById<View>(R.id.left_4) as ImageView
        rectangle_13 = findViewById<View>(R.id.rectangle_13) as View
        rectangle_14 = findViewById<View>(R.id.rectangle_14) as View
        your_email = findViewById<View>(R.id.your_email) as TextView
        your_name = findViewById<View>(R.id.your_name) as TextView
        your_password = findViewById<View>(R.id.your_password) as TextView
        repeat_password = findViewById<View>(R.id.repeat_password) as TextView
        rectangle_15 = findViewById<View>(R.id.rectangle_15) as View
        rectangle_16 = findViewById<View>(R.id.rectangle_16) as View
        rectangle_17 = findViewById<View>(R.id.rectangle_17) as View
        sign_up = findViewById<View>(R.id.sign_up) as TextView


        //custom code goes here
    }
}