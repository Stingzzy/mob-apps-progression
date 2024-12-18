package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val registerNowLabel = findViewById<TextView>(R.id.register)
        registerNowLabel.setOnClickListener {
            Log.d("tag", "Register now clicked")

            val goToRegisterIntent = Intent(this, SignUp::class.java)
            startActivity(goToRegisterIntent)
        }
        val nextButtonClick = findViewById<Button>(R.id.nextButton)
        nextButtonClick.setOnClickListener {
        
        }


    }

}