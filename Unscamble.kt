// App type: Empty Activity
// File: MainActivity.kt
// rename the package name in the below line with your folder name

package com.example.unscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import androidx.compose.foundation.layout.*
import android.content.pm.ActivityInfo
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val words = listOf("android", "kotlin", "unscramble", "application", "developer")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val ind = Random.nextInt(words.size)
            Unscramble(scrambleWord(words[ind]),words[ind])
        }
    }
}
private fun scrambleWord(word: String): String {
    return word.toList().shuffled().joinToString("")
}

@Composable
fun Unscramble(scrambledWord: String,correctWord:String) {
    val context = LocalContext.current
    var userInput by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = scrambledWord)
        Text(text = "Unscramble the word using all the letters")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userInput,
            onValueChange = { userInput = it },
            modifier = Modifier.width(300.dp)
            , label = {
                Text(text="Enter word")
            })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            result = if (userInput.text.equals(correctWord, ignoreCase = true)) {
                (context as? MainActivity)?.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                "Correct!"
            } else {
                "Try Again!"
            }

        }) {
            Text(text = "Submit")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = result)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Unscramble("lleho","hello")
}