package com.demo.cartrack.usecase

import androidx.lifecycle.MutableLiveData
import com.demo.cartrack.storage.CarTrackStoarge
import com.demo.cartrack.storage.StorageConstants
import com.demo.cartrack.utils.LoginUtils
import kotlinx.coroutines.*
import org.koin.core.KoinComponent

class LoginUseCase(private val carTrackStorage: CarTrackStoarge): KoinComponent {

    private val saveDetailsMutableLiveData = MutableLiveData<Boolean>()
    private val checkDetailsMutableLiveData = MutableLiveData<Boolean>()
    private val useCaseJob = Job()
    private val useCaseCoroutineScope =
        CoroutineScope(Dispatchers.IO + useCaseJob)

    fun validateUserName(userName: String): Pair<Boolean, String> {
        return if (!LoginUtils.checkValidUserNameLength(userName)) {
            Pair(false, "User name must be 8 to 16 digits")
        } else if (!LoginUtils.checkUsernameSpecialCharacter(userName)) {
            Pair(false, "User name should n't contain Special Characters")
        } else if(!LoginUtils.checkAlphanumeric(userName)) {
            Pair(false, "User name should be Alphanumeric")
        } else {
            Pair(true, "")
        }
    }

    fun validatePassword(password: String): Pair<Boolean, String> {
        return if(LoginUtils.checkUsernameSpecialCharacter(password)) {
            if (!LoginUtils.checkValidPasswordLength(password)) {
                Pair(false, "Password atleast 8 digits")
            } else if(!LoginUtils.checkAlphanumeric(password)) {
                Pair(false, "Password should be Alphanumeric")
            } else {
                Pair(false, "Password should contain atleast one special character")
            }
        } else {
            Pair(true, "")
        }
    }

    fun storeUserDetails(userName: String, password: String): MutableLiveData<Boolean> {
        useCaseCoroutineScope.launch {
            withContext(Dispatchers.Main) {
                try {
                    saveDetailsMutableLiveData.value =  carTrackStorage.storeDetails(
                        userName,
                        password
                    )
                } catch (e: Exception) {
                    saveDetailsMutableLiveData.value = false
                }
            }
        }
        return saveDetailsMutableLiveData
    }

    fun checkUserDetails(userName: String, password: String): MutableLiveData<Boolean> {
        useCaseCoroutineScope.launch {
            withContext(Dispatchers.Main) {
                try {
                    checkDetailsMutableLiveData.value = carTrackStorage.checkLoginUser(
                        userName,
                        password
                    )
                } catch (e: Exception) {
                    checkDetailsMutableLiveData.value = false
                }
            }
        }
        return checkDetailsMutableLiveData
    }



}