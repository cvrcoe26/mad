// App type: Empty Activity
// change the image
// File: MainActivity.kt
// rename the package name in the below line with your folder name

package com.example.bookorder


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookOrderApp()
        }
    }
}

@Composable
fun BookOrderApp() {
    var authorName by remember { mutableStateOf(TextFieldValue("")) }
    var quantity by remember { mutableStateOf(TextFieldValue("")) }
    var totalPrice by remember { mutableStateOf(0) }

    var showSummary by remember { mutableStateOf(false) }
    var dispatchDate by remember { mutableStateOf("") }

    if (showSummary) {
        OrderSummaryScreen(authorName.text, quantity.text.toIntOrNull() ?: 0, totalPrice, dispatchDate) {
            showSummary = false
        }
    } else {
        OrderInputScreen(
            authorName = authorName,
            onAuthorNameChange = { authorName = it },
            quantity = quantity,
            onQuantityChange = { quantity = it },
            onCalculatePrice = { qty ->
                totalPrice = qty * 10 // Assuming each book costs $10
                dispatchDate = calculateDispatchDate(qty)
            },
            onOrder = {
                showSummary = true
            }
        )
    }
}

@Composable
fun OrderInputScreen(
    authorName: TextFieldValue,
    onAuthorNameChange: (TextFieldValue) -> Unit,
    quantity: TextFieldValue,
    onQuantityChange: (TextFieldValue) -> Unit,
    onCalculatePrice: (Int) -> Unit,
    onOrder: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Book Image")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = authorName,
            onValueChange = onAuthorNameChange,
            label = { Text("Book Author Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = quantity,
            onValueChange = onQuantityChange,
            label = { Text("Quantity") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val qty = quantity.text.toIntOrNull() ?: 0
            onCalculatePrice(qty)
            onOrder()
        }) {
            Text("Calculate Total Price")
        }
    }
}

@Composable
fun OrderSummaryScreen(authorName: String, quantity: Int, totalPrice: Int, dispatchDate: String, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Order Summary", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Book Author Name: $authorName")
        Text(text = "Book Quantity: $quantity")
        Text(text = "Total Price: $$totalPrice")
        Text(text = "Dispatch Date: $dispatchDate")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBack) {
            Text("Back to Order")
        }
    }
}

fun calculateDispatchDate(quantity: Int): String {
    val currentDate = Calendar.getInstance()
    val dispatchDate = when {
        quantity > 10 && quantity < 20 -> currentDate.apply { add(Calendar.DAY_OF_MONTH, 2) }
        quantity >= 20 && quantity < 50 -> currentDate.apply { add(Calendar.DAY_OF_MONTH, 5) }
        quantity >= 50 && quantity < 100 -> currentDate.apply { add(Calendar.DAY_OF_MONTH, 7) }
        else -> currentDate.apply { add(Calendar.DAY_OF_MONTH, 10) }
    }
    return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(dispatchDate.time)
}

@Preview(showBackground = true)
@Composable
fun PreviewOrderApp() {
    BookOrderApp()
}
