// App type: Empty Activity
// rename the package name in the below line with your folder name
// File: MainActivity.kt

package com.example.sleeptracker

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import java.time.LocalDateTime
import java.time.Duration

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SleepTrackerApp()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SleepTrackerApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "sleep_tracker") {
        composable("sleep_tracker") { SleepTrackerScreen(navController) }
        composable("sleep_quality/{duration}") { backStackEntry ->
            val duration = backStackEntry.arguments?.getString("duration")?.toLong() ?: 0L
            SleepQualityScreen(duration)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SleepTrackerScreen(navController: NavController) {
    var startTime by remember { mutableStateOf<LocalDateTime?>(null) }
    var endTime by remember { mutableStateOf<LocalDateTime?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sleep Tracker", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Start Time: ${startTime?.toString() ?: "Not started"}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "End Time: ${endTime?.toString() ?: "Not stopped"}")
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            startTime = LocalDateTime.now()
            endTime = null
        }) {
            Text(text = "Start Tracking")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            endTime = LocalDateTime.now()
            if (startTime != null && endTime != null) {
                val sleepDurationInSeconds = Duration.between(startTime, endTime).seconds
                navController.navigate("sleep_quality/$sleepDurationInSeconds")
            }
        }) {
            Text(text = "Stop Tracking")
        }
    }
}

@Composable
fun SleepQualityScreen(duration: Long) {
    val qualityMessage = when {
        duration > 300 -> "Sleep Quality: Good"
        duration in 121..300 -> "Sleep Quality: Poor"
        else -> "Sleep Quality: Very Poor"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sleep Quality Rating", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = qualityMessage)
    }
}