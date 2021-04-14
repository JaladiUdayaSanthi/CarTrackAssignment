package com.demo.cartrack.viewmodel

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.cartrack.constants.UrlConstants
import com.demo.cartrack.data.DetailsResponse
import com.demo.cartrack.repository.ServiceRepository
import com.demo.cartrack.usecase.DetailsUseCase
import com.demo.cartrack.usecase.LoginUseCase
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import java.lang.Error

class LoginViewModel(private val loginUseCase: LoginUseCase,
private val serviceRepo: ServiceRepository): ViewModel(), KoinComponent {

    fun storeUserDetails(userName: String, password: String): MutableLiveData<Boolean> {
       return loginUseCase.storeUserDetails(userName, password)
    }

    fun checkUserDetails(userName: String, password: String): MutableLiveData<Boolean> {
        return loginUseCase.checkUserDetails(userName, password)
    }


    fun validateUserName(userName: String): Pair<Boolean, String> {
        return loginUseCase.validateUserName(userName)
    }

    fun validatePassword(password: String): Pair<Boolean, String> {
        return loginUseCase.validatePassword(password)
    }

    fun getDetails(cbOnResult: (DetailsResponse) -> Unit, cbOnError: (Error) -> Unit) {
        viewModelScope.launch {
            val result = serviceRepo.getUserDetails(UrlConstants.url)
            if (result is Result.Success) {
                cbOnResult(result.success)
            } else {
                result is Result.Error
                cbOnError(result.error)
            }
        }
    }
}