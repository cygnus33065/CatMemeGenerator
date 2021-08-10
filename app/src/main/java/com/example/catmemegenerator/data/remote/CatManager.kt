package com.example.catmemegenerator.data.remote

import com.example.catmemegenerator.data.remote.retrofit.Cat
import com.example.catmemegenerator.data.remote.retrofit.CatApi
import retrofit2.Response

object CatManager {
    private val service: CatApi
    private val retrofit = RetrofitService.providesRetrofitService()

    init{
        service = retrofit.create(CatApi::class.java)
    }

    suspend fun getCat(filter:String?): Response<Cat> {
        return service.getCat(filter)
    }

    suspend fun getCatSays(text:String, color:String?, filter:String?, size:String?):Response<Cat>{
        return service.getCatSays(text,color,filter,size)
    }

    suspend fun getCatGif(filter:String?): Response<Cat>{
        return service.getCatGif(filter)
    }

    suspend fun getCatSaysGif(text:String, color:String?, filter:String?, size:String?): Response<Cat>{
        return service.getCatSaysGif(text,color,filter,size)
    }
}