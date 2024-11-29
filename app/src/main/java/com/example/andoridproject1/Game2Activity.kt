package com.example.andoridproject1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andoridproject1.ui.theme.AndoridProject1Theme
import kotlin.random.Random

class Game2Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndoridProject1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Game2View(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Game2View(modifier: Modifier) {

    Column(modifier = Modifier.padding(20.dp)) {
        var i = 10
        Row {
            Button(onClick = {
                Log.i("tablica","[$i,$i,$i]")
                i++
            }) { Text("Start test") }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Game2Preview() {
    AndoridProject1Theme {
        //Game2View()
    }
}