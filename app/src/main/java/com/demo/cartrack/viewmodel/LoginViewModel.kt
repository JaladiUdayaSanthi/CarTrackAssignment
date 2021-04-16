package com.demo.cartrack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.cartrack.repository.GetDetailsData
import com.demo.cartrack.repository.GetDetailsRepository
import com.demo.cartrack.usecase.LoginUseCase
import org.koin.core.KoinComponent
import java.lang.Error

class LoginViewModel(private val loginUseCase: LoginUseCase,
private val reposiotry: GetDetailsRepository): ViewModel(), KoinComponent {

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

    fun getDetails(cbOnResult: (GetDetailsData?) -> Unit, cbOnError: (Error?) -> Unit) {
       reposiotry.getUserDetails(
           {
               cbOnResult(it)
           },{
              cbOnError(it)
           }
       )
    }
}