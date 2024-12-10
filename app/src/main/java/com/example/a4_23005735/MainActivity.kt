package com.example.a4_23005735

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a4_23005735.ui.theme.A4_23005735Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A4_23005735Theme {
                MainScreen { name, carnet ->
                    // Navegación a CountryListActivity
                    val intent = Intent(this, CountryListActivity::class.java).apply {
                        putExtra("NAME", name)
                        putExtra("CARNET", carnet)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun MainScreen(onSubmit: (String, String) -> Unit) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var carnet by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Brenda Samara Escobar Avila") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = carnet,
                    onValueChange = { carnet = it },
                    label = { Text("23005735") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        onSubmit(name.text, carnet.text)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cargar")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    A4_23005735Theme {
        MainScreen { _, _ -> }
    }
}
