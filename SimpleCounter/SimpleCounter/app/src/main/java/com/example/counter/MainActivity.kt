package com.example.counter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counter.ui.theme.CounterTheme
import com.example.counter.ui.theme.WaterMark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    simpleCounter()
                }
            }
        }
    }// OnCreate Method

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun simpleCounter() {
        setContent(){
            var count by remember {
                mutableStateOf(0)
            }// Var Count

            Scaffold(
                topBar = { TopAppBar(title = { Text("Simple Counter") }) },
                content = {
                    // Create a column layout
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ){
                        // Display the current count
                        Text(
                            text = "Count: $count",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        // Create a button to increment the count
                        Button(
                            onClick = { count++ },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(text = "Increment")
                        }

                        Text(
                            text="Developed: Bry Lim",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            color = WaterMark.grey100 //custom color.
                        )
                        Text(
                            text="Kotlin Android JetPack Compose3",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            color = WaterMark.grey100 //custom color.
                        )
                    }
                }
            )//Scaffold
        }//Set Content
    }//SimpleCounter
}//MainActivity