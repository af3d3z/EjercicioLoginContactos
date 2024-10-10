package com.example.jetpackcomposecontactos

import android.content.Context
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val context = LocalContext.current
    val gradientColors = listOf(
        Color.Red,
        Color.Magenta,
        Color.Blue,
        Color.Cyan,
        Color.Green,
        Color.Yellow,
        Color.Red
    )
    var text:String by rememberSaveable { mutableStateOf("") }
    var passText:String by remember {mutableStateOf("")}
    val brush = remember {
        Brush.linearGradient(colors =  gradientColors)
    }
    Column {
        Text(
            text = "Login",
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            style = TextStyle(brush = brush),
            modifier = modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = {Text("Usuario")},
            maxLines = 1,
            textStyle = TextStyle(brush = brush),
            leadingIcon = {
                Icon(Icons.Default.AccountCircle, contentDescription = "Icono persona")
            },
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = passText,
            onValueChange = {passText = it},
            label = {Text("Password")},
            maxLines = 1,
            textStyle = TextStyle(brush = brush),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Icono candado")
            },
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Button(onClick = { LoginOnClick(text, passText, context) }, modifier = modifier.align(Alignment.CenterHorizontally)) {
            Text("Login")
        }
    }
}

fun LoginOnClick (user: String, pass: String, ctx:Context){
    if (user.equals("alonso") && pass.equals("12345")){

    }else {
        Toast.makeText(ctx, "Credenciales incorrectas.", Toast.LENGTH_SHORT).show()
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