package com.example.andoridproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andoridproject1.ui.theme.AndoridProject1Theme
import kotlin.random.Random

@Suppress("DEPRECATION")
class Game1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndoridProject1Theme {
                val resetAction = remember { mutableIntStateOf(0) }

                Scaffold(
                    topBar = { MyAppBarGame1(this, resetAction) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MyView(
                        this, resetAction,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    fun back() {
        onBackPressed()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBarGame1(activity: Game1Activity, resetAction: MutableIntState) {
    TopAppBar(
        title = { Text("Game 1") },
        actions = {
            IconButton(onClick = {
                reset(activity)
            }) {
                Icon(
                    Icons.Filled.Refresh,
                    contentDescription = stringResource(R.string.action_game_1)
                )
            }
            IconButton(onClick = {
                activity.back()
            }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.action_back)
                )
            }
        }
    )
}

fun reset(activity: Game1Activity) {
//    activity.test()
}

@Composable
fun MyView(activity: Game1Activity, resetAction: MutableIntState, modifier: Modifier = Modifier) {

    var number by remember { mutableIntStateOf(Random.nextInt(20, 50)) }
    var noTrials by remember { mutableIntStateOf(0) }

    fun endLevel() {
        noTrials = 0

    }

    fun nextTrial() {
        noTrials++

        if (number == 0) {
            endLevel()
        }
    }


    Column(modifier = modifier) {
        Row {
            Text(
                text = "$number", modifier = Modifier
                    .padding(10.dp)
                    .alpha(0.8f), color = Color.Blue,
                fontSize = 50.sp
            )

        }
        Row {
            Button(onClick = {
                number += 2
                nextTrial()
            }) { Text("+2") }
            Button(onClick = { number += 5 }) { Text("+5") }
            Button(onClick = { number -= 7 }) { Text("-7") }
        }
        Row {
            Text("Liczba prób: $noTrials")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    AndoridProject1Theme {
//        MyView()
    }
}