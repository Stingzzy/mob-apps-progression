package com.example.myapplication

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsTestCase  {
    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("")
        assertFalse(isEmailValid)
    }
    //Following test only checks format for "@", not optimal check
    @Test
    fun givenWrongFormatEmail_thenReturnFalse(){
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("sflahmrwerew")
        assertFalse(isEmailValid)
    }

    @Test
    fun givenCorrectFormat_thenReturnTrue(){
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("abc@keed.li")
        assertTrue(isEmailValid)
    }

    @Test
    fun givenEmptyPassword_thenReturnFalse(){
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("")
        assertFalse(isPasswordValid)
    }

    @Test
    fun givenFilledPassword_thenReturnTrue(){
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("password")
        assertTrue(isPasswordValid)
    }

}