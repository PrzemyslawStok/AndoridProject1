package com.example.andoridproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andoridproject1.ui.theme.AndoridProject1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndoridProject1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyView(
                        User("Przemysław", "Stokłosa", "Bielsko-Biała", "Wiśniowa", "43-300"),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class User(
    val name: String,
    val surname: String,
    val addressLine1: String,
    val addressLine2: String,
    val zipCode: String
)

@Composable
fun MyView(user: User, modifier: Modifier = Modifier) {
    var number  by remember { mutableIntStateOf(0) }

    Column {
        Row {
            Image(
                painter = painterResource(R.drawable.ic_picture),
                contentDescription = "",
                modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Text(
                text = "${user.name} ${user.surname}",
                modifier = modifier
            )
        }
        Row {
            Text(
                text = "$number", modifier = Modifier
                    .padding(10.dp)
                    .alpha(0.8f), color = Color.Blue
            )
            Button(onClick = { number++ }) { Text("+1") }
        }
        Text(text = user.addressLine2)
        Text(text = user.zipCode)

    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    AndoridProject1Theme {
        MyView(User("Przemysław", "Stokłosa", "Bielsko-Biała", "Wiśniowa", "43-300"))
    }
}