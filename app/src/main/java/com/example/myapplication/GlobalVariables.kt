package com.example.myapplication

import android.app.Application

class GlobalVariables : Application() {
    companion object {
        val emails = ArrayList<String>()
        val passwords = ArrayList<String>()

        init {
            emails.add("test@te.st")
            passwords.add("1234")
        }
    }
}