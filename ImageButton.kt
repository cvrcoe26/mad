// App type: Empty Activity
// replace the images (ic_launcher_background)
// rename the package name in the below line with your folder name

// MainActivity.kt

package com.example.imagebutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { ImageDesc() }
    }
}

@Composable
fun ImageDesc() {
    var clicked by remember { mutableStateOf(false) }
    Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Box {
            Image(
                    modifier = Modifier.width(200.dp).height(200.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "First image"
            )
            Button(modifier = Modifier.align(Alignment.Center), onClick = { clicked = !clicked }) {
                Text(text = "${if(clicked) "hide" else "show"} image")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        if (clicked) {
            Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "second image"
            )
            Text(
                    modifier = Modifier.padding(start = 40.dp, end = 40.dp),
                    text =
                            "A mango is an edible stone fruit produced by the tropical tree Mangifera indica. It originated from the region between northwestern Myanmar, Bangladesh, and northeastern India."
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageDesc()
}
