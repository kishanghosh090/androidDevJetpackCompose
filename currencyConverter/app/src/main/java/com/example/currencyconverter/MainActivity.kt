package com.example.currencyconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyconverter.ui.theme.CurrencyConverterTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyConverterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Currency Converter") }

                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        UnitConverter()
                    }
                }
            }
        }
    }
}


@Composable
fun UnitConverter(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val value = remember { mutableStateOf("") }
        OutlinedTextField(
            value = value.value,
            label = {
                Text(text = "Input")
            },
            onValueChange = {
                value.value = it
            }
        )
        Row(
           modifier = Modifier
               .padding(12.dp),
        ) {
            val context = LocalContext.current
            Box{
                Button(onClick = {
                    Toast.makeText(context, "Convert", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Convert")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "arrow")
                }
                DropdownMenu(expanded = true, onDismissRequest = {  }) {
                    DropdownMenuItem(text = {
                        Text("Centimeters")
                    }, onClick = {
                        Toast.makeText(context, "Centimeters", Toast.LENGTH_SHORT).show()
                    })
                    DropdownMenuItem(text = {
                        Text("Meters")
                    }, onClick = {
                        Toast.makeText(context, "Centimeters", Toast.LENGTH_SHORT).show()
                    })
                }
            }
            Spacer(modifier.padding(12.dp))
            Box{
                Button(onClick = {
                    Toast.makeText(context, "Convert", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Convert")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "arrow")
                }
                DropdownMenu(expanded = true, onDismissRequest = {  }) {
                    DropdownMenuItem(text = {
                        Text("Centimeters")
                    }, onClick = {
                        Toast.makeText(context, "Centimeters", Toast.LENGTH_SHORT).show()
                    })
                    DropdownMenuItem(text = {
                        Text("Meters")
                    }, onClick = {
                        Toast.makeText(context, "Centimeters", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
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
    CurrencyConverterTheme {
        Greeting("Android")
    }
}
