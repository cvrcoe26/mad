// App type: Empty Views Activity
// rename the package name in the below line with your folder name

//*************MainActivity.kt**********************

package com.example.lifecycle

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,"CREATE()  CALLED",Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"START()  CALLED",Toast.LENGTH_SHORT).show()
    }
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext,"RESTART() CALLED",Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext,"PAUSE()  CALLED",Toast.LENGTH_SHORT).show()

    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"RESUME()  CALLED",Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"STOP()  CALLED",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"DESTROY() CALLED",Toast.LENGTH_SHORT).show()
    }
}

//************************activity_main.xml ********************************
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView

        android:layout_width="303dp"
        android:layout_height="66dp"
        android:text="ACTIVITY LIFE CYCLE DEMONSTRATION..!"
        android:ems="10"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="TextViewEdits"/>

</androidx.constraintlayout.widget.ConstraintLayout>