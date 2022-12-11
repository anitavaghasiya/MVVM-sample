package com.mvvm.mvvmlearnkotlin.repository


import com.mvvm.mvvmlearnkotlin.model.WallpaperResponse
import com.mvvm.mvvmlearnkotlin.data.source.WallpaperSource
import com.mvvm.mvvmlearnkotlin.utils.Resource

class MainRepository(private val wallpaperSource: WallpaperSource) {

//    suspend fun getUsers(): Resource<WallpaperResponse?> {
//        return wallpaperSource.getWallpaperData()
//    }
}