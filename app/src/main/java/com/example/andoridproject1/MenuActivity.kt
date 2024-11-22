package com.example.andoridproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuView(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MenuView(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(20.dp)) {
        Row {
            Text(
                text = "next view",
                fontSize = 50.sp
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    AndoridProject1Theme {
        MenuView()
    }
}

