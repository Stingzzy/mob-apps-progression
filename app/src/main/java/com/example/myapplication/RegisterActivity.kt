package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import com.example.myapplication.GlobalVariables.Companion.emails
import com.example.myapplication.GlobalVariables.Companion.passwords
import com.example.myapplication.CredentialsManager.Companion.isEmailValid
import com.example.myapplication.CredentialsManager.Companion.isPasswordValid
import com.example.myapplication.CredentialsManager.Companion.isNameValid
import com.example.myapplication.CredentialsManager.Companion.isPhoneNumberValid

class RegisterActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logInTextButton: MaterialTextView = findViewById(R.id.log_in)

        val emailLayout: TextInputLayout = findViewById(R.id.email_layout)
        val emailText: TextInputEditText = findViewById(R.id.email_text)

        val passwordLayout: TextInputLayout = findViewById(R.id.password_layout)
        val passwordText: TextInputEditText = findViewById(R.id.password_text)

        val nameLayout: TextInputLayout = findViewById(R.id.full_name_layout)
        val nameText: TextInputEditText = findViewById(R.id.full_name_text)

        val numberLayout: TextInputLayout = findViewById(R.id.phone_number_layout)
        val numberText: TextInputEditText = findViewById(R.id.phone_number_text)

        val nextButton: MaterialButton = findViewById(R.id.next)

        fun checkEmailPresence(email: String): Boolean{
            if(emails.contains(email))
                return true
            return false
        }


        logInTextButton.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }

        nextButton.setOnClickListener {
            if(!isNameValid(nameText.text.toString())){
                nameLayout.error = "Name cannot be empty"

            }
            else{
                nameLayout.error = null
                if(!isEmailValid(emailText.text.toString())){
                    emailLayout.error = "Email is not valid"
                }
                else if(checkEmailPresence(emailText.text.toString())){
                    emailLayout.error = "Email is already registered"
                }
                else {
                    emailLayout.error = null
                    if(!isPhoneNumberValid(numberText.text.toString())){
                        numberLayout.error = "Phone number is not valid"
                    }
                    else {
                        numberLayout.error = null
                        if(!isPasswordValid(passwordText.text.toString())){
                            passwordLayout.error = "Password is not valid!"
                        }
                        else {
                            passwordLayout.error = null
                            emails.add(emailText.text.toString())
                            passwords.add(passwordText.text.toString())
                            val intent = Intent(this, LogInActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }
        }
    }
}