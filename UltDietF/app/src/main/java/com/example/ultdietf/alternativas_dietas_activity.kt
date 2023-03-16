
package com.example.ultdietf

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class alternativas_dietas_activity : Activity() {
    private var choose_yout_diet: TextView? = null
    private var rectangle_5: View? = null
    private var rectangle_6: View? = null
    private var rectangle_7: View? = null
    private var option_1: TextView? = null
    private var option_3: TextView? = null
    private var option_2: TextView? = null
    private var left_5: ImageView? = null
    private var diet: ImageView? = null
    private var rectangle_19: View? = null
    private var skip: TextView? = null
    private var rectangle_18: View? = null
    private var choose: TextView? = null
    private var salad: ImageView? = null
    private var meat: ImageView? = null
    private var fish: ImageView? = null
    @SuppressLint("MissingInflatedId")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alternativas_dietas)
        choose_yout_diet = findViewById<View>(R.id.choose_yout_diet) as TextView
        rectangle_5 = findViewById(R.id.rectangle_5) as View
        rectangle_6 = findViewById(R.id.rectangle_6) as View
        rectangle_7 = findViewById(R.id.rectangle_7) as View
        option_1 = findViewById<View>(R.id.option_1) as TextView
        option_3 = findViewById<View>(R.id.option_3) as TextView
        option_2 = findViewById<View>(R.id.option_2) as TextView
        left_5 = findViewById<View>(R.id.left_5) as ImageView
        diet = findViewById<View>(R.id.diet) as ImageView
        rectangle_19 = findViewById<View>(R.id.rectangle_19) as View
        skip = findViewById<View>(R.id.skip) as TextView
        rectangle_18 = findViewById<View>(R.id.rectangle_18) as View
        choose = findViewById<View>(R.id.choose) as TextView
        salad = findViewById<View>(R.id.salad) as ImageView
        meat = findViewById<View>(R.id.meat) as ImageView
        fish = findViewById<View>(R.id.fish) as ImageView


        //custom code goes here
    }
}