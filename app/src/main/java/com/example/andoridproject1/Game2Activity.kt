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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andoridproject1.ui.theme.AndoridProject1Theme

class Game2Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndoridProject1Theme {
                Scaffold(topBar = { MyAppBar() }) { innerPadding ->
                    Game2View(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun evaluate(a: Int, b: Int, f1: (Int, Int) -> Int): Int {
    val tag = "TAB"
    Log.i(tag, "$a(f1)$b=${f1(a, b)}")
    return f1(a, b)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar() {
    TopAppBar(
        title = { Text("Moja Aplikacja") },
        actions = {
            IconButton(onClick = { /* Akcja 1 */ }) {
                Icon(Icons.Filled.Search, contentDescription = "Szukaj")
            }
            IconButton(onClick = { /* Akcja 2 */ }) {
                Icon(Icons.Filled.Settings, contentDescription = "Ustawienia")
            }
        }
    )
}

@Composable
fun Game2View(modifier: Modifier) {
    val tag = "TAB"

    var sum: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    val mul: (Int, Int) -> Int = { a, b -> a * b }
    val mul1 = { a: Int, b: Int -> a * b }


    val div = { a: Int, b: Int -> (a / b).toDouble() }

    val item_no: (Int) -> Int = { i -> i }

    val array = Array(10) { i -> i }
    Log.e(tag, "${array.asList()}")

    evaluate(5, 100, sum)
    evaluate(5, 100, mul)

    evaluate(5, 10, { x, y -> x * 2 * y })

    evaluate(10, 100) { x, y -> x + 2 * y }

    //Log.d(tag, "${array[0](5, 10)}")

    val a = 2
    val b = 5
    Log.d(tag, "$a+$b = ${sum(a, b)}")

    Column(modifier = modifier) {
        val array = Array(10) { i -> (i * i * i) }
        Row {
            Button(onClick = {
                Log.i(tag, "${array.asList()}")

//                array.forEach {
//                    Log.d(TAG, "$it")
//                }

                Log.v(tag, "${array.map { i -> (i + 1) * (i + 1) }}")

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