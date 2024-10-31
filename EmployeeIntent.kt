// App type: Empty views Activity
// rename the package name in the below line with your folder name


// ------------------ MainActivity.kt -------------------------------------
package com.example.employee

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput: EditText = findViewById(R.id.editTextName)
        val idInput: EditText = findViewById(R.id.editTextId)
        val departmentInput: EditText = findViewById(R.id.editTextDepartment)
        val submitButton: Button = findViewById(R.id.buttonSubmit)

        val nameTextView: TextView = findViewById(R.id.textViewName)
        val idTextView: TextView = findViewById(R.id.textViewId)
        val departmentTextView: TextView = findViewById(R.id.textViewDepartment)

        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val id = idInput.text.toString()
            val department = departmentInput.text.toString()

            nameInput.visibility = View.GONE
            idInput.visibility = View.GONE
            departmentInput.visibility = View.GONE
            submitButton.visibility = View.GONE

            nameTextView.visibility = View.VISIBLE
            idTextView.visibility = View.VISIBLE
            departmentTextView.visibility = View.VISIBLE

            nameTextView.text = "Name: $name"
            idTextView.text = "ID: $id"
            departmentTextView.text = "Department: $department"
        }
    }
}


// ------------------------- activity_main.xml -------------------------------

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editTextName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Name" />

    <EditText
        android:id="@+id/editTextId"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter ID" />

    <EditText
        android:id="@+id/editTextDepartment"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Department" />

    <Button
        android:id="@+id/buttonSubmit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Submit" />

    <TextView
        android:id="@+id/textViewName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:visibility="gone" />

    <TextView
        android:id="@+id/textViewId"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:visibility="gone" />

    <TextView
        android:id="@+id/textViewDepartment"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:visibility="gone" />
</LinearLayout>