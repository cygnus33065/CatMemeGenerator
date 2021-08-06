package com.example.catmemegenerator.data.remote

import com.example.catmemegenerator.BASE_URL
import com.example.catmemegenerator.TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitService {
    private fun providesOkHttpClient(): OkHttpClient{
        val httpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    fun providesRetrofitService(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(providesOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}