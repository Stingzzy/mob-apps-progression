package com.example.myapplication

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import com.example.myapplication.LoginUtils.Companion.checkEmail
import com.example.myapplication.LoginUtils.Companion.checkPassword

class LoginActivityTest {

    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        assertEquals(false, checkEmail(""))
    }

    @Test
    fun givenWrongFormatEmail_thenReturnFalse() {
        assertEquals(false, checkEmail("example.com"))
    }

    @Test
    fun givenProperEmail_thenReturnTrue() {
        assertEquals(true, checkEmail("test@te.st"))
    }

    @Test
    fun givenFilledPassword_thenReturnTrue() {
        assertEquals(true, checkPassword("1234"))
    }

    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        assertEquals(false, checkPassword(""))
    }
}