package com.demo.cartrack.repository

import com.demo.cartrack.constants.UrlConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url


interface ServiceAPI {
    @Headers("Content-Type: application/json")
    @GET
    fun getList(@Url url: String): Call<Servers>
}