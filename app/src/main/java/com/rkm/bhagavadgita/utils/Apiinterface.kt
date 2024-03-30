package com.rkm.bhagavadgita.utils

import com.rkm.bhagavadgita.model.allchaptersdata
import com.rkm.bhagavadgita.model.allchaptersdataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Apiinterface {

    @Headers(
        "Accept: application/json",
        "X-RapidAPI-Key: 3b3afd9c4dmshd4a4ab3305ed852p194d7djsn7b88dcfd7845",
        "X-RapidAPI-Host: bhagavad-gita3.p.rapidapi.com")



    @GET("v2/chapters/")
    suspend fun getchapters(): List<allchaptersdataItem>







}