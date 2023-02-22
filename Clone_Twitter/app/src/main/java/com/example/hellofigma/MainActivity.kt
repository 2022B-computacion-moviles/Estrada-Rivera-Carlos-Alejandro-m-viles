/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.hellofigma
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.hellofigma.ajustes.Ajustes
import com.example.hellofigma.tweetfeed.*
import com.example.hellofigma.ui.theme.Twitter
import com.example.hellofigma.ui.theme.TwitterTheme
import com.google.relay.compose.*
import com.google.relay.compose.BoxScopeInstance.boxAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Add this line
            //TweetFeed()
            //rememberCompositionContext()

            val View = LocalView.current

            TwitterTheme {
                RecyclerView()
            }

        }
    }
}

@Composable
fun ListItem(name : String){

    val expanded = remember { mutableStateOf(false)}
    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){
        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {
            Row{
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Row {
                        Column (Modifier.padding(5.dp)) {
                            Image(painter = painterResource(id = R.drawable.ajustes_mask), contentDescription = "Me Gusta")
                        }
                        Text(color = MaterialTheme.colors.secondary,text = name, style = MaterialTheme.typography.h5.copy(
                            fontWeight = FontWeight.ExtraBold
                        ))
                    }

                    Text(color = MaterialTheme.colors.secondary, text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
                    Text(color = MaterialTheme.colors.primaryVariant, text = "Leer Más")
                    Row{
                        Column (Modifier.padding(10.dp)) {
                            Image(painter = painterResource(id = R.drawable.tweet_feed_retweet_stroke_icon), contentDescription = "Retweet")
                        }
                        Column (Modifier.padding(10.dp)){
                            Image(painter = painterResource(id = R.drawable.tweet_feed_heart_stroke_icon), contentDescription = "Like")
                        }
                        Column(Modifier.padding(10.dp)) {
                            Image(painter = painterResource(id = R.drawable.tweet_feed_comment_stroke_icon), contentDescription = "Comment")
                        }
                        Column(Modifier.padding(10.dp)) {
                            Image(painter = painterResource(id = R.drawable.tweet_feed_share_stroke_icon), contentDescription = "Share")
                        }

                    }

                }

                Button(onClick = { expanded.value = !expanded.value },colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
            }

            if (expanded.value){

                Column(modifier = Modifier.padding(
                    bottom = extraPadding.coerceAtLeast(0.dp)
                )) {
                    Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
                }

            }
        }





    }


    }

@Composable
fun RecyclerView(names : List<String> = List(10){"Persona $it"}){

    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){

        items(items = names){ name ->

            ListItem(name = name)

        }
    }
    Row ( Modifier.boxAlign(Alignment.TopStart, offset = DpOffset(
        x = 15.0.dp,
        y = 7.5.dp
    ))) {
        Image(painter = painterResource(id = R.drawable.twitter_log), contentDescription = "Logo", Modifier.width(25.dp))
    }
    //Ajustes
    val context = LocalContext.current
    val View = LocalView.current

    Button(onClick = { Toast.makeText(context, "Cambiando a Ajustes", Toast.LENGTH_SHORT).show()
        },Modifier
        .boxAlign(Alignment.TopEnd, offset = DpOffset(
        x = 360.0.dp,
        y = -5.0.dp
    )),colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)) {
        Row () {
            Image(painter = painterResource(id = R.drawable.baseline_settings_suggest_24), contentDescription = "Ajustes")
        }
    }
    Row(Modifier.boxAlign(Alignment.BottomEnd, offset = DpOffset(
        x = 130.0.dp,
        y = 715.0.dp
    ))){
        Column (Modifier.padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.tweet_feed_home_solid_icon), contentDescription = "Me Gusta")
        }
        Column (Modifier.padding(10.dp)){
            Image(painter = painterResource(id = R.drawable.tweet_feed_search_stroke_icon), contentDescription = "Mail")
        }
        Column(Modifier.padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.tweet_feed_bell_stroke_icon), contentDescription = "Notificación")
        }
        Column(Modifier.padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.tweet_feed_mail_stroke_icon), contentDescription = "Retweet")
        }
    }

}