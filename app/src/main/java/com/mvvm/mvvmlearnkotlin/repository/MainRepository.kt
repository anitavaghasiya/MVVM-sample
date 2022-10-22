package com.mvvm.mvvmlearnkotlin.repository


import com.mvvm.mvvmlearnkotlin.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers(clientId: String) = apiHelper.getWallpaperData(clientId)
}