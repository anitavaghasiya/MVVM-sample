package com.mvvm.mvvmlearnkotlin.network

import com.mvvm.mvvmlearnkotlin.model.WallpaperResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(EndPoint.photos)
    suspend fun getWallpapers(): Response<WallpaperResponse>
}