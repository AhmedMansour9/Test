package com.example.test.network

import com.example.test.model.Holiday
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("publicholidays/{year}/{countryCode}")
    suspend fun getHolidays(
        @Path("year") year: Int,
        @Path("countryCode") countryCode: String
    ): List<Holiday>


}