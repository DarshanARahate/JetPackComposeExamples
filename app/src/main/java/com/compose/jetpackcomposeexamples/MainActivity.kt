package com.compose.jetpackcomposeexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.jetpackcomposeexamples.ui.theme.JetPackComposeExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeExamplesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
//                    ContryCard()
                    ConstraintLayoutCompose()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(text = name)

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeExamplesTheme {
//        Greeting("Android")
        ContryCard()
    }
}

@Composable
fun ContryCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .padding(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .height(125.dp)
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
            ) {

                Box(
                    modifier = Modifier.padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val imageResId = R.drawable.`in` // Replace with your PNG image resource ID
                    val imagePainter: Painter = painterResource(id = imageResId)
                    Image(
                        painter = imagePainter, contentDescription = "Country Flag",
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    text = "India"
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    text = "New Delhi"
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Republic of India",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Asia",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "South Asia",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.2f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "₹",
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .drawBehind {
                                    drawCircle(
                                        color = Color.LightGray,
                                        radius = this.size.maxDimension
                                    )
                                },
                            textAlign = TextAlign.Center
                        )
                    }


                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "India Rupee",
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "+91",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = ".in",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}