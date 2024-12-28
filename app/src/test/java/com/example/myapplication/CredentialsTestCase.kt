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

    @Test
    fun givenCorrectEmailAndPassword_thenReturnTrue(){
        val credentialsManager = CredentialsManager()

        val isLoginCredentialsValid = credentialsManager.validateCredentials("test@te.st","password1")
        assertTrue(isLoginCredentialsValid)
    }

    @Test
    fun givenWrongCredential_thenReturnFalse(){
        val credentialsManager = CredentialsManager()

        //Wrong Password
        assertFalse(credentialsManager.validateCredentials("test@te.st","passwor"))
        //Wrong Email
        assertFalse(credentialsManager.validateCredentials("not_an_email","password1"))
        //WRONG Email and Password
        assertFalse(credentialsManager.validateCredentials("not_an_email","passwor"))
    }
    @Test
    fun testFullName(){
        val credentialsManager = CredentialsManager()
        assertTrue(credentialsManager.isFullNameValid("James Hunt"))
        assertFalse(credentialsManager.isFullNameValid(""))
    }

    @Test
    fun testPhoneNumber(){
        val credentialsManager = CredentialsManager()
        assertTrue(credentialsManager.isValidPhoneNumber("569872222"))
        assertFalse(credentialsManager.isValidPhoneNumber("sdfaf11g"))

    }
    @Test
    fun testValidateCredentialsForSignUp() {
        val credentialsManager = CredentialsManager()
        // Valid full name, email, phone, password, and checkbox checked
        assertTrue(
            credentialsManager.validateSignUp(
                "James Hunt", "test@te.st", "4558967325", "password1", true
            )
        )

        // Invalid full name
        assertFalse(
            credentialsManager.validateSignUp(
                "", "test@te.st", "4558967325", "password1", true
            )
        )

        // Invalid email
        assertFalse(
            credentialsManager.validateSignUp(
                "James Hunt", "not_an_email", "4558967325", "password1", true
            )
        )

        // Invalid phone number
        assertFalse(
            credentialsManager.validateSignUp(
                "James Hunt", "test@te.st", "458996", "password1", true
            )
        )

        // Invalid password
        assertFalse(
            credentialsManager.validateSignUp(
                "James Hunt", "test@te.st", "4589765332", "passwor", true
            )
        )

        // Checkbox not checked
        assertFalse(
            credentialsManager.validateSignUp(
                "James Hunt", "example@test.com", "1234567890", "password123", false
            )
        )
    }

}
