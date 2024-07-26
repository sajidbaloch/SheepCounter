package app.sheepcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SheepCounterApp()
        }
    }
}

@Composable
fun SheepCounterApp() {
    var count by remember { mutableStateOf(1) }
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString(), fontSize = 48.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count++ }) {
            Text("Count Sheep")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (count > 0) {
            Image(
                painter = painterResource(id = R.drawable.sheep),
                contentDescription = "Sheep",
                modifier = Modifier
                    .size(100.dp)
                    .background(colors[Random.nextInt(colors.size)])
            )
        }
    }
}
