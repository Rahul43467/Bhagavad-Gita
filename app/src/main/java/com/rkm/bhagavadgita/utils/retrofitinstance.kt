package com.rkm.bhagavadgita.utils


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object retrofitinstance {

    val api:Apiinterface by lazy {
        Retrofit.Builder().baseUrl(base.base)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Apiinterface::class.java)

    }
    }

