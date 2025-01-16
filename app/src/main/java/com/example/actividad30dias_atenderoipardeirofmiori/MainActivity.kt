package com.example.actividad30dias_atenderoipardeirofmiori

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
        circuitoList = Datasource.loadCircuitos(),
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
                painter = painterResource(circuito.nombre),
                contentDescription = stringResource(circuito.imageRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(circuito.imageRes),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall

            )
        }
    }
}