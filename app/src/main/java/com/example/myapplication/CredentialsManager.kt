package com.example.myapplication

class CredentialsManager {
    fun isEmailValid(email: String): Boolean {

        return email.isNotEmpty() && email.contains("@")
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }
}