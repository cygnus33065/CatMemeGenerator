package com.example.catmemegenerator.data.remote.retrofit

import com.squareup.moshi.Json

data class Cat(
    @field:Json(name="url") val url:String?
)


