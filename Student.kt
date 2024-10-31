// App type: Empty Activity
// File: MainActivity.kt
// rename the package name in the below line with your folder name

package com.example.studentdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

data class Student(
    val name: String,
    val rollNumber: Int,
    val marks: Map<String, Int>
) {
    val totalMarks: Int = marks.values.sum()
    val percentage: Float = totalMarks / marks.size.toFloat()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val student = Student(
            name = "John Doe",
            rollNumber = 12345,
            marks = mapOf(
                "Mathematics" to 85,
                "Physics" to 90,
                "Chemistry" to 78,
                "English" to 88,
                "Computer Science" to 95
            )
        )

        setContent {
            StudentInfoApp(student = student)
        }
    }
}

@Composable
fun StudentInfoApp(student: Student) {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StudentInfo(student)
        }
    }
}

@Composable
fun StudentInfo(student: Student) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Student Information",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Name: ${student.name}",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Roll Number: ${student.rollNumber}",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Marks:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        student.marks.forEach { (subject, mark) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = subject, fontSize = 18.sp)
                Text(text = "$mark", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total Marks: ${student.totalMarks}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Percentage: %.2f%%".format(student.percentage),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
