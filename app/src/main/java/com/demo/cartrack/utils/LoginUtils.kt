package com.demo.cartrack.utils

object LoginUtils {

    fun getCountryList(): List<String> {
        return listOf("Singapore", "Malaysia", "Thailand", "Indonesia")
    }

    fun checkValidUserNameLength(userName: String): Boolean {
        return userName.trim().length in 8..16
    }

    fun checkUsernameSpecialCharacter(userName: String): Boolean {
        return userName.matches(Regex("[a-zA-Z0-9]*"))
    }

    fun checkAlphanumeric(userName: String): Boolean {
        return userName.matches(Regex("(^[A-Za-z]+[0-9]|[0-9]+[A-Za-z])[A-Za-z0-9]*$"))

    }

    fun checkValidPasswordLength(userName: String): Boolean {
        return userName.trim().length > 8
    }

}
