package com.example.actividad30dias_atenderoipardeirofmiori

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.actividad30dias_atenderoipardeirofmiori.model.Circuito
import com.example.actividad30dias_atenderoipardeirofmiori.ui.theme.Actividad30Dias_ATenderoIPardeiroFMioriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad30Dias_ATenderoIPardeiroFMioriTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CircuitoApp() {
    CircuitoList(
        circuitoList = Datasource().loadCircuito,
    )
}

@Composable
fun CircuitoList(circuitoList: List<Circuito>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(circuitoList) { circuito ->
            circuitoCard(
                circuito = circuito,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "No olvidaré Road Atlana",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Actividad30Dias_ATenderoIPardeiroFMioriTheme {
        Greeting("Android")
    }
}