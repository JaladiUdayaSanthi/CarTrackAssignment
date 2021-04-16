package com.demo.cartrack.repository

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response

@Keep
data class GetDetailsData(
    @SerializedName("response") val response: List<DetailsList>
)

@Keep
data class DetailsList(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("address") val address: Address,
    @SerializedName("phone") val phone: String,
    @SerializedName("website") val website: String,
    @SerializedName("company") val company: Company
)

@Keep
data class Address(
    @SerializedName("street") val street: String,
    @SerializedName("suite") val suite: String,
    @SerializedName("city") val city: String,
    @SerializedName("zipcode") val zipcode: String,
    @SerializedName("geo") val geo: Geo
)


@Keep
data class Company(
    @SerializedName("name") val name: String,
    @SerializedName("catchPhrase") val catchPhrase: String,
    @SerializedName("bs") val bs: String
)

@Keep
data class Geo(
    @SerializedName("lat") val lat: String,
    @SerializedName("lng") val lng: String
)
