package com.example.catmemegenerator.data.remote

import com.example.catmemegenerator.Resource
import com.example.catmemegenerator.data.remote.retrofit.Cat
import retrofit2.Response

object CatRepo {
    suspend fun getCat(filter:String?): Resource<Cat>{
        return try{
            val catResponse = CatManager.getCat(filter)
            if(catResponse.isSuccessful && catResponse.body() != null){
                Resource.Success(catResponse.body()!!)
            } else {
                Resource.Error(null, "No weather data found")
            }
        } catch (e: Exception){
                Resource.Error(e, "Unexpected Error")
        }
    }

    suspend fun getCatSays(text:String, color:String?, filter:String?, size:String?): Resource<Cat>{
        return try{
            val catResponse = CatManager.getCatSays(text, color, filter, size)
            if(catResponse.isSuccessful && catResponse.body() != null){
                Resource.Success(catResponse.body()!!)
            } else{
                Resource.Error(null, "No weather data found")
            }
        } catch(e: Exception){
            Resource.Error(e, "Unexpected Error")
        }
    }

    suspend fun getCatGif(filter: String?): Resource<Cat>{
        return try{
            val catResponse = CatManager.getCatGif(filter)
            if(catResponse.isSuccessful && catResponse.body() != null){
                Resource.Success(catResponse.body()!!)
            } else{
                Resource.Error(null, "No weather data found")
            }
        } catch(e: Exception){
            Resource.Error(e, "Unexpected Error")
        }
    }

    suspend fun getCatSaysGif(text: String, color: String?, filter: String?, size:String?): Resource<Cat>{
        return try{
            val catResponse = CatManager.getCatSaysGif(text, color, filter, size)
            if(catResponse.isSuccessful && catResponse.body() != null){
                Resource.Success(catResponse.body()!!)
            } else{
                Resource.Error(null, "No weather data found")
            }
        } catch(e: Exception){
            Resource.Error(e, "Unexpected Error")
        }
    }
}