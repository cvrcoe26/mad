// App type: Empty Activity
// include the below line in dependencies in the build.gradle.kts (module) in gradle scripts
// implementation("androidx.navigation:navigation-compose:2.8.3")
// rename the package name in the below line with your folder name
// File: MainActivity.kt

package com.example.login

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynavigation.ui.theme.MyNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavigationTheme {
                MyApplicationNavigation()
            }
        }
    }
}

@Composable
fun ScreenA(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val loginImage: Painter = painterResource(id = R.drawable.dice_1)

        Image(
            painter = loginImage,
            contentDescription = "login image",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Login")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (email == "cse" && password == "cse") {
                navController.navigate("screenB/$email/$password")
            } else {
                navController.navigate("screenC/$email/$password")
            }
            Log.i("Credential", "email: $email password: $password")
        }) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Forgot Password?", modifier = Modifier.clickable { })
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "or sign in with")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = message)
    }
}

@Composable
fun ScreenB(email: String, password: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Email is: $email")
        Text(text = "Password is: $password")
        Text(text = "Valid")
    }
}

@Composable
fun ScreenC(email: String, password: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val errorImage: Painter = painterResource(id = R.drawable.dice_1)
        Image(
            painter = errorImage,
            contentDescription = "Invalid email or password",
            modifier = Modifier.size(200.dp)
        )

        Text(text = "Invalid email or password.")
    }
}

@Composable
fun MyApplicationNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "/screenA") {
        composable("/screenA") {
            ScreenA(navController)
        }
        composable("screenB/{email}/{password}") {
            val email = it.arguments?.getString("email") ?: ""
            val password = it.arguments?.getString("password") ?: ""
            ScreenB(email, password)
        }
        composable("screenC/{email}/{password}") {
            val email = it.arguments?.getString("email") ?: ""
            val password = it.arguments?.getString("password") ?: ""
            ScreenC(email, password)
        }
    }
}
