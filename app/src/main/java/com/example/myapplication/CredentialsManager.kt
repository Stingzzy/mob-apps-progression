package com.example.myapplication

class CredentialsManager {
    //Login Validations
    //Email - format check
    private val emailFormat =
        ("^[a-zA-Z0-9+%\\-]{1,256}" +
                "@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+$").toRegex()

    fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && email.matches(emailFormat)
    }

    //password length and content check ALSO signup
    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty() && password.length >= 8
    }

    //email and password validated ALSO use for signup
    fun validateCredentials(email:String, password:String): Boolean{
        return isEmailValid(email) && isPasswordValid(password)
    }

    //Signup Validations

    //Name check
    fun isFullNameValid(fullName: String):Boolean{
        return fullName.isNotEmpty()
    }

    //phone number check without country code consideration
    fun isValidPhoneNumber(phoneNumber: String): Boolean{
        val phonePattern = "^[0-9]{9,}$".toRegex()
        return phoneNumber.matches(phonePattern)
    }

    fun termsAccepted(t_and_cChecked: Boolean): Boolean{
        return t_and_cChecked
    }

    fun validateSignUp(
        fullName:String,
        email: String,
        phone:String,
        password: String,
        TandC:Boolean
        ): Boolean{
        return isFullNameValid(fullName) &&
                isEmailValid(email) &&
                isValidPhoneNumber(phone) &&
                isPasswordValid(password) &&
                termsAccepted(TandC)
    }







}