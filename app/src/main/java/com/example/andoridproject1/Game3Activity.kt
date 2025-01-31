package com.example.andoridproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.andoridproject1.ui.theme.AndoridProject1Theme

class Game3Activity : ComponentActivity() {
    val gameboard = GameBoard(6, 5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            AndoridProject1Theme {
                Scaffold(topBar = { MyAppBar3() }) { innerPadding ->
                    Game3View(
                        this,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar3() {
    TopAppBar(
        title = { Text("Game 2") },
        actions = {
            IconButton(onClick = { /* Action 1 */ }) {
                Icon(
                    Icons.Filled.Call,
                    contentDescription = stringResource(R.string.action_settings)
                )
            }
            IconButton(onClick = { /* Action 2 */ }) {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = stringResource(R.string.action_game_1)
                )
            }
        }
    )
}

@Composable
fun Game3View(gameActivity: Game3Activity, modifier: Modifier) {
    val gameboard = gameActivity.gameboard

    Column(modifier = modifier) {
        Row {
            Button(onClick = {
                gameboard.array()
            }) { Text("Rzędy ${gameboard.rows}, Kolumny ${gameboard.cols}") }

        }
        Row {
            Button(onClick = {
                gameboard.changeSize(7, 7)
            }) { Text("Test 1") }

        }
        Row {
            Button(onClick = {
                gameboard.changeSize(5, 5)
            }) { Text("Test 2") }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Game3Preview() {
    AndoridProject1Theme {
//        Game3View()
    }
}