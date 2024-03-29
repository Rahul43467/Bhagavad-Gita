package com.rkm.bhagavadgita.utils

import com.rkm.bhagavadgita.model.allchaptersdata
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiinterface {

   @GET("chapters/?limit=18")

    suspend fun getchaptersdata(

       @Query("n") name: String,
       @Query("nt") name_transliterated: String,
       @Query("ntr") name_translated: String,
       @Query("vc") verses_count: String,
       @Query("cn") chapter_number: String,
       @Query("apikey") apikey: String,

       ): Response<allchaptersdata>





}