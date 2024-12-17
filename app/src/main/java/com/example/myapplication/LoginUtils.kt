package com.example.myapplication
import com.example.myapplication.CredentialsManager.Companion.isEmailValid
import com.example.myapplication.CredentialsManager.Companion.isPasswordValid
import com.example.myapplication.GlobalVariables.Companion.emails
import com.example.myapplication.GlobalVariables.Companion.passwords

class LoginUtils {
    companion object {
        fun checkEmail(email: String): Boolean {
            if(isEmailValid(email)){
                if(email == emails[0])
                    return true
            }
            return false
        }

        fun checkPassword(password: String): Boolean {
            if(isPasswordValid(password)){
                if(password == passwords[0])
                    return true
            }
            return false
        }
    }
}