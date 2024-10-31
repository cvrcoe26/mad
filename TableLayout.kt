// App type: Empty Views Activity
// rename the package name in the below line with your folder name

// MainActivity.kt

package com.example.tablelayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            Toast.makeText(this, "Name: $name\nEmail: $email", Toast.LENGTH_LONG).show()
        }
    }
}


//activity_main.xml

<?xml version="1.0" encoding="utf-8"?>

<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    android:stretchColumns="1">
    <TableRow>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Name"
            android:padding="8dp"/>
        <EditText
            android:id="@+id/nameEditText"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Enter your name"/>
    </TableRow>
    <TableRow>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Email"
            android:padding="8dp"/>
        <EditText
            android:id="@+id/emailEditText"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Enter your email"/>
    </TableRow>
    <TableRow>
        <Button
            android:id="@+id/submitButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Submit"
            android:layout_span="2"
            android:layout_gravity="center"/>
    </TableRow>
</TableLayout>