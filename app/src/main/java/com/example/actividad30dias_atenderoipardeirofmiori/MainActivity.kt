package com.example.actividad30dias_atenderoipardeirofmiori

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.actividad30dias_atenderoipardeirofmiori.model.Circuito
import com.example.actividad30dias_atenderoipardeirofmiori.ui.theme.Actividad30Dias_ATenderoIPardeiroFMioriTheme
import com.example.actividad30dias_atenderoipardeirofmiori.data.Datasource



// ADRIÁN TENDERO, ÍKER PARDEIRO Y FEDERICO MIORI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad30Dias_ATenderoIPardeiroFMioriTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color.Red
                    ) {
                    CircuitoApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CircuitoApp() {
    Scaffold(
        topBar = {
            Heather()
        }
    ) {
        CircuitoList(
            circuitoList = Datasource().loadCircuitos(),
        )
    }

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
    var expanded by remember { mutableStateOf(false) }
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(200,0,0))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = LocalContext.current.getString(circuito.nombre),
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1f),
                        style = MaterialTheme.typography.headlineSmall,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Expandible(
                        expanded = expanded,
                        onClick = { expanded = !expanded },

                    )
                }
            }
            if (expanded) {
                DescripcionCircuito(
                    circuito.descripcion, modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun DescripcionCircuito (
    @StringRes descripcionCircuito: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(175, 0, 0))
    ) {
        Spacer(Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = stringResource(descripcionCircuito),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        Spacer(Modifier.height(10.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Heather(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size) * 2f)
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.fwonk_d_6358a63d),

                    contentDescription = null
                )
                /*Text(
                    text = stringResource(R.string.nombre),
                    style = MaterialTheme.typography.displayLarge,
                    //fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )*/
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(200, 0, 0)
        ),
        modifier = modifier
    )
}

@Composable
private fun Expandible(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier.size(48.dp)
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(36.dp)
        )
    }
}