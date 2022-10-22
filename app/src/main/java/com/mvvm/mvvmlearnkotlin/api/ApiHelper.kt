package com.mvvm.mvvmlearnkotlin.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getWallpaperData(clientId: String) = apiService.getWallpapers(clientId)
}