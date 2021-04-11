package com.demo.cartrack.viewmodel

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.cartrack.constants.UrlConstants
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import java.lang.Error

class LoginViewModel(): ViewModel(), KoinComponent {

    fun storeUserDetails(userName: String, password: String): Boolean {
        return true
    }

    fun checkUserDetails(userName: String, password: String): Boolean {
        return true
    }


    fun validateUserName(userName: String): Pair<Boolean, String> {
        return Pair(true,"")
    }

    fun validatePassword(password: String): Pair<Boolean, String> {
        return Pair(true, "")
    }
}