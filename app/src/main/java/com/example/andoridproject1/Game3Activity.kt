package com.example.andoridproject1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andoridproject1.ui.theme.AndoridProject1Theme
import kotlin.random.Random

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
    val gameBoard = gameActivity.gameboard

    Column(modifier = modifier) {
        Row {
            Button(onClick = {
                gameBoard.printGameBoard()
            }) { Text("Rzędy ${gameBoard.rows}, Kolumny ${gameBoard.cols}") }

        }
        Row {
            Button(onClick = {
                gameBoard.changeSize(7, 7)
            }) { Text("Test 1") }

        }
        Row {
            Button(onClick = {
                gameBoard.changeSize(5, 5)
            }) { Text("Test 2") }

        }
        Row {
            Button(onClick = {
                gameBoard.squareClicked(1, 4)
            }) { Text("Test 3 (pole gry)") }

        }
        DrawGameBoard(gameBoard)
    }
}

@Composable
fun DrawGameBoard(gameBoard: GameBoard) {
    var number by remember { mutableIntStateOf(0) }
    val itemsList = (0..<gameBoard.cols * gameBoard.rows).toList()
    LazyVerticalGrid(
        columns = GridCells.Fixed(gameBoard.cols),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp)

    ) {
        items(itemsList) { index ->
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(
                        if (gameBoard.getState(
                                index / (gameBoard.rows - 1),
                                index % gameBoard.cols,
                            ) == 1
                        ) Color.Gray else Color.Yellow
                    )
                    .clickable {
                        val col = index % gameBoard.cols
                        val row: Int = index / (gameBoard.rows - 1)

                        Log.i("tag", "($row,$col) ")
                        gameBoard.squareClicked(row, col)
                        number++
                    }
            )

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