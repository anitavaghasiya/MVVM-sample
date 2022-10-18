package com.mvvm.mvvmlearnkotlin.repository

import com.mvvm.mvvmlearnkotlin.model.ProfileImage
import com.mvvm.mvvmlearnkotlin.model.WallpaperResp

interface MainActRepo {

    suspend fun getServicesApiCall(): WallpaperResp?
}