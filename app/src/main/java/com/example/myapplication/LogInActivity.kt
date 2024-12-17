package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import com.google.android.material.textview.MaterialTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.example.myapplication.LoginUtils.Companion.checkEmail
import com.example.myapplication.LoginUtils.Companion.checkPassword

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailLayout: TextInputLayout = findViewById(R.id.email_layout)
        val passwordLayout: TextInputLayout = findViewById(R.id.password_layout)
        val emailText: TextInputEditText = findViewById(R.id.email_text)
        val passwordText: TextInputEditText = findViewById(R.id.password_text)
        val registerTextButton: MaterialTextView = findViewById(R.id.register)
        val nextButton: MaterialButton = findViewById(R.id.next)


        registerTextButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        nextButton.setOnClickListener {
           if(checkEmail(emailText.text.toString())){
               emailLayout.error = null
               if(checkPassword(passwordText.text.toString())){
                   val intent = Intent(this, MainActivity::class.java)
                   startActivity(intent)
                   finish()
               }
               else {
                   passwordLayout.error = "Password is invalid"
               }
           }
            else {
               emailLayout.error =  "Email is invalid"
            }
        }
    }
}