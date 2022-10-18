package com.mvvm.mvvmlearnkotlin.datasource

import com.mvvm.mvvmlearnkotlin.model.WallpaperResp

interface IWallpaperListSource {

    suspend fun getServicesApiCall(): WallpaperResp
}