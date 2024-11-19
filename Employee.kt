// App type: Empty views Activity
// rename the package name in the below line with your folder name


// ------------------ MainActivity.kt -------------------------------------

package com.example.tryproj

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val employeeList = mutableListOf<Employee>()
    private var currentIndex = 0
    private val maxEmployees = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput: EditText = findViewById(R.id.editTextName)
        val idInput: EditText = findViewById(R.id.editTextId)
        val departmentInput: EditText = findViewById(R.id.editTextDepartment)
        val submitButton: Button = findViewById(R.id.buttonSubmit)
        val employeeDisplay: LinearLayout = findViewById(R.id.employeeDisplay)

        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val id = idInput.text.toString()
            val department = departmentInput.text.toString()

            if (currentIndex < maxEmployees) {
                val employee = Employee(name, id, department)
                employeeList.add(employee)
                displayEmployees(employeeDisplay)

                currentIndex++
                if (currentIndex >= maxEmployees) {
                    nameInput.visibility = View.GONE
                    idInput.visibility = View.GONE
                    departmentInput.visibility = View.GONE
                    submitButton.visibility = View.GONE
                } else {
                    nameInput.text.clear()
                    idInput.text.clear()
                    departmentInput.text.clear()
                }
            }
        }
    }

    private fun displayEmployees(employeeDisplay: LinearLayout) {
        employeeDisplay.removeAllViews()
        for (employee in employeeList) {
            val textView = TextView(this)
            textView.text = "Name: ${employee.name}, ID: ${employee.id}, department: ${employee.department}"
            employeeDisplay.addView(textView)
        }
    }

    data class Employee(val name: String, val id: String, val department: String)
}

// ------------------------- activity_main.xml -------------------------------

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">
    <EditText
        android:id="@+id/editTextName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Name"
        android:inputType="textPersonName"
        android:layout_marginBottom="8dp" />
    <EditText
        android:id="@+id/editTextId"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter ID"
        android:inputType="text"
        android:layout_marginBottom="8dp" />
    <EditText
        android:id="@+id/editTextDepartment"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Department"
        android:inputType="text"
        android:layout_marginBottom="16dp" />
    <Button
        android:id="@+id/buttonSubmit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Submit" />
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp">

        <LinearLayout
            android:id="@+id/employeeDisplay"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical" />
    </ScrollView>
</LinearLayout>
