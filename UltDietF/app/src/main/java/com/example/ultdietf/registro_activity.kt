package com.example.ultdietf

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.ultdietf.db.DbUser

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

        // Get the information of the user
        sign_up!!.setOnClickListener {
            DbUser.userAux.setemail(your_email!!.text.toString())
            DbUser.userAux.setname(your_name!!.text.toString())

            // Verify password if true setPassword
            if (your_password.toString().equals(repeat_password.toString())) {
                DbUser.userAux.setemail(your_password!!.text.toString())
                val answerInsertUser = DbUser.userAux.insertUser(this)
                if (answerInsertUser > 0) {
                    Toast.makeText(this, "USER REGISTERED", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "USER REGISTRATION ERROR", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "VERIFY PASSWORD", Toast.LENGTH_LONG).show()
                your_password!!.setText("")
                repeat_password!!.setText("")
                your_password!!.requestFocus()
            }

        }
    }

    fun goToActivity(
        clase: Class<*>
    ) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}