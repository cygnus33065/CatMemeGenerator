package com.example.catmemegenerator.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    val api: CatApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://cataas.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(CatApi::class.java)
    }
}