package com.example.movilescomputacionce

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.movilescomputacionce.databinding.ActivityAcicloVidaBinding

class ACicloVida : AppCompatActivity() {

    var textoGlobal = ""
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAcicloVidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAcicloVidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_aciclo_vida)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        mostrarSncakbar("onCreate")
    }

    override fun onStart() {
        super.onStart()
        mostrarSncakbar("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        mostrarSncakbar("onRestart")
    }

    override fun onResume() {
        super.onResume()
        mostrarSncakbar("onResume")
    }

    override fun onStop() {
        super.onStop()
        mostrarSncakbar("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        mostrarSncakbar("onDestroy")
    }

    override fun onPause() {
        super.onPause()
        mostrarSncakbar("onPause")
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_aciclo_vida)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun mostrarSncakbar(texto:String){
        textoGlobal += texto
        Snackbar.make(findViewById(R.id.cl_ciclo_vida),
            textoGlobal, Snackbar.LENGTH_LONG)
            .setAction("Action",null).show()
    }
}