package com.example.catmemegenerator.data.remote.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatApi{

    @GET("/cat")
    suspend fun getCat(
        @Query("filter")filter:String?,
        @Query("json")json:Boolean = true
    ): Response<Cat>

    @GET("/cat/says/{text}")
    suspend fun getCatSays(
        @Path("text") text: String,
        @Query("color") color:String?,
        @Query("filter") filter:String?,
        @Query("size") size:String?,
        @Query("json")json:Boolean = true
    ):Response<Cat>


    @GET("/cat/gif")
    suspend fun getCatGif(
        @Query("filter")filter:String?,
        @Query("json")json:Boolean = true
    ): Response<Cat>

    @GET("/cat/gif/says/{text}")
    suspend fun getCatSaysGif(
        @Path("text") text: String,
        @Query("color") color:String?,
        @Query("filter") filter:String?,
        @Query("size") size:String?,
        @Query("json")json:Boolean = true
    ):Response<Cat>
}