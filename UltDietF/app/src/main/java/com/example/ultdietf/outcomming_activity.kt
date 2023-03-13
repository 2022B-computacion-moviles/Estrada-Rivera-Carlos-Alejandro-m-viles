
package com.example.ultdietf

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.example.ultdietf.R

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
    }

    companion object {
        private const val TIEMPO_DEMOSTRACION = 3000 // 2 segundos
        private val SIGUIENTE_ACTIVIDAD: Class<*> = outcomming2_activity::class.java
    }
}