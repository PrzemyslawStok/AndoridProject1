package com.example.andoridproject1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andoridproject1.ui.theme.AndoridProject1Theme

class MenuActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndoridProject1Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyActivityActionBar(this) }) { innerPadding ->
                    MenuView(
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
fun MyActivityActionBar(activity: ComponentActivity) {
    TopAppBar(
        title = { Text(stringResource(R.string.choose_game)) },
        actions = {
            IconButton(onClick = { val intent = Intent(activity, Game1Activity::class.java)
                activity.startActivity(intent) }) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = stringResource(R.string.action_game_1)
                )
            }
            IconButton(onClick = { /* Action 2 */ }) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = stringResource(R.string.action_game_2)
                )
            }

            IconButton(onClick = { /* Action 2 */ }) {
                Icon(
                    Icons.Filled.Face,
                    contentDescription = stringResource(R.string.action_game_3)
                )
            }
        }
    )
}

@Composable
fun MenuView(activity: ComponentActivity, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button(onClick = {
            val intent = Intent(activity, Game1Activity::class.java)
            activity.startActivity(intent)
        }) { Text("Game1") }
        Button(onClick = {
            val intent = Intent(activity, Game2Activity::class.java)
            activity.startActivity(intent)
        }) { Text("Game2") }
        Button(onClick = { }) { Text("Game3") }


    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    AndoridProject1Theme {
        //MenuView()
    }
}

