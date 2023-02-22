package com.example.hellofigma

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.hellofigma.ajustes.Ajustes
import com.example.hellofigma.ui.theme.TwitterTheme
import com.google.relay.compose.BoxScopeInstance.boxAlign

class AjustesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    Ajustes()// Add this line
                    val context = LocalContext.current
                    val View = LocalView.current
                        com.example.hellofigma.ajustes.LeftArrowIcon(modifier = Modifier.clickable {
                            val navigate = Intent(this@AjustesActivity, AjustesActivity::class.java)
                            startActivity(navigate)

                            Toast
                                .makeText(context, " Volviendo a otro RecyclerView", Toast.LENGTH_SHORT)
                                .show()

                        })



                    rememberCompositionContext()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TwitterTheme() {
        Greeting("Android")
    }
}