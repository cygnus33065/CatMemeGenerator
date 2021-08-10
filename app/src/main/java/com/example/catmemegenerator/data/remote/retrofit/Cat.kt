package com.example.catmemegenerator.data.remote.retrofit

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cat(
    @field:Json(name="url") val url:String?
)


