package pe.edu.upc.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.democompose.ui.theme.DemoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    DemoComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    val counterState = remember { mutableStateOf(0) }

    Column {
        Column (modifier = Modifier.weight(1f)){
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
            Divider(color = Color.Transparent, thickness = 32.dp)
        }
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {

    Button(onClick = { updateCount(count + 1) }) {
        Text("$count times")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Preview(name = "Text preview")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}