package com.example.jetpackcomposecontactos

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecontactos.ui.theme.JetpackComposeContactosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeContactosTheme {
                Scaffold(content = { p ->
                    LoginPage(Modifier.padding(p))

                })
            }
        }
    }
}

@Composable
fun LoginPage(modifier: Modifier){
    var text by rememberSaveable { mutableStateOf("") }
    var passText by remember {mutableStateOf("")}
    Column {
        Text(
            text = "Login",
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            modifier = modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = {Text("Usuario")},
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = passText,
            onValueChange = {passText = it},
            label = {Text("Password")},
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Button() { }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeContactosTheme {
        Greeting("Android")
    }
}