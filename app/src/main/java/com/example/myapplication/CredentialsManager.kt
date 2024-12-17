package com.example.myapplication

class CredentialsManager {
    companion object {
        fun isEmailValid(email: String): Boolean {
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
            return email.matches(emailRegex.toRegex())
        }

        fun isPasswordValid(password: String): Boolean {
            return password.isNotEmpty()
        }

        fun isNameValid(name: String): Boolean {
            return name.isNotEmpty()
        }

        fun isPhoneNumberValid(number: String): Boolean {
            val numberRegex = "^\\d{9}$"
            return number.matches(numberRegex.toRegex())
        }
    }
}