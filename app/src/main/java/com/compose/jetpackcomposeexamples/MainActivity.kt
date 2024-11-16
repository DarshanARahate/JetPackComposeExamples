package com.compose.jetpackcomposeexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetpackcomposeexamples.ui.theme.JetPackComposeExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeExamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    Box (contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
                        ParentComposable()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = name)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeExamplesTheme {
        Greeting("Android")
    }
}

@Composable
fun ParentComposable() {
    var parentData by remember {
        mutableStateOf("Initail data from Parent")
    }
    var receivedDataFromChild by remember {
        mutableStateOf("")
    }

    Column {
        FirstComposable(
            dataToPass = parentData,
            onDataReceived = { dataFromChild ->
                receivedDataFromChild = dataFromChild
            }
        )

        Text(text = "Data From Child: $receivedDataFromChild")

        Button(onClick = {
            parentData = "Update data from parent"
        }) {
            Text(text = "Update Data Sent to Child")
        }
    }
}

@Composable
fun FirstComposable(dataToPass: String, onDataReceived: (String) -> Unit) {
    Column {
        Text(text = "Data from Parent: $dataToPass")

        Button(onClick = {
            onDataReceived("Data From FirstComposable")
        }) {
            Text(text = "Send Data to Parent")
        }
    }
}
