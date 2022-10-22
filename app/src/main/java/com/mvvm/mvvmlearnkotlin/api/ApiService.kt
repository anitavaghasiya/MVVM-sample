package com.mvvm.mvvmlearnkotlin.api

import com.mvvm.mvvmlearnkotlin.model.WallpaperResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    suspend fun getWallpapers(@Query("client_id") id: String):List<WallpaperResponseItem>
}