package com.demo.cartrack.repository

import com.demo.cartrack.constants.URL
import com.demo.cartrack.extension.enqueue
import retrofit2.Call
import java.lang.Error

class GetDetailsRepository(private val serviceAPI: ServiceAPI) {
    fun getUserDetails(cbOnResult: (GetDetailsData?) -> Unit, cbOnError: (Error?) -> Unit) =
        getDetails().enqueue({response ->
            val data: GetDetailsData? = response.body()
            cbOnResult(data)
        },{
           cbOnError(Error(it))
        })

    private fun getDetails(): Call<GetDetailsData> {
        return  serviceAPI.getUserDetails(URL.detailsURL)
    }

}