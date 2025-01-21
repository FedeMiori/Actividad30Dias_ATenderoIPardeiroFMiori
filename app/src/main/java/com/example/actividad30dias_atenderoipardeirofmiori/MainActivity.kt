package com.example.actividad30dias_atenderoipardeirofmiori

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad30dias_atenderoipardeirofmiori.model.Circuito
import com.example.actividad30dias_atenderoipardeirofmiori.ui.theme.Actividad30Dias_ATenderoIPardeiroFMioriTheme
import com.example.actividad30dias_atenderoipardeirofmiori.data.Datasource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad30Dias_ATenderoIPardeiroFMioriTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    CircuitoApp()
                }
            }
        }
    }
}

@Composable
fun CircuitoApp() {
    CircuitoList(
        circuitoList = Datasource().loadCircuitos(),
    )
}

@Composable
fun CircuitoList(circuitoList: List<Circuito>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(circuitoList) { circuito ->
            CircuitoCard(
                circuito = circuito,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CircuitoCard(circuito: Circuito, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(circuito.imageRes),
                contentDescription = stringResource(circuito.nombre),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(333.dp),
                contentScale = ContentScale.Crop
            )
            Box( // Usamos Box para añadir el fondo
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(180, 0, 0)) // Fondo rojo
            ) {
                Text(
                    text = LocalContext.current.getString(circuito.nombre),
                    modifier = Modifier
                        .padding(16.dp), // Añade espacio interno
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    //fontWeight = FontWeight.Bold,
                    color = Color.White // Color del texto
                )
            }
        }
    }
}