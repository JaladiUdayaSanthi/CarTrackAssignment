package com.demo.cartrack.repository

import com.demo.cartrack.data.DetailsResponse

interface ServiceRepository{
    suspend fun getUserDetails(url: String): Result<DetailsResponse>
}