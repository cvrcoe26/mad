// App type: Empty Activity
// File: MainActivity.kt
// rename the package name in the below line with your folder name

package com.example.tipcalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCal()
        }
    }
}

@Composable
fun TipCal() {
    var billAmount by remember {
        mutableStateOf("")
    }
    var tipPercentage by remember {
        mutableStateOf("")
    }
    var tipAmount by remember {
        mutableStateOf("")
    }
    var totalAmount by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = billAmount, onValueChange = {
            billAmount = it
        }, label = {
            Text(text = "Enter bill amount")
        })
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(value = tipPercentage, onValueChange = {
            tipPercentage  = it
        }, label = {
            Text(text = "Enter tip percentage")
        })
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(enabled=false,value = tipAmount, onValueChange = {
            tipAmount  = it
        }, label = {
            Text(text = "Tip Amount")
        })
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(enabled = false, value = totalAmount, onValueChange = {
            tipPercentage  = it
        }, label = {
            Text(text = "Total Amount")
        })
        Spacer(modifier = Modifier.height(4.dp))
        Button(modifier = Modifier.width(270.dp), onClick = {
            Log.i("Bill","Bill amount: ${billAmount}, Tip Percentage: ${tipPercentage}")
            val bill = billAmount.toDoubleOrNull() ?: 0.0
            val percentage = tipPercentage.toDoubleOrNull() ?: 0.0
            val tp = bill * (percentage / 100)
            tipAmount = tp.toString()
            totalAmount = (bill+tp).toString()
        }) {
            Text(text = "Pay Bill")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TipCal()
}