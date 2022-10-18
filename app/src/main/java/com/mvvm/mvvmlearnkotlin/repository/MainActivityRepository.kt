package com.mvvm.mvvmlearnkotlin.repository

import com.mvvm.mvvmlearnkotlin.model.WallpaperResp
import com.mvvm.mvvmlearnkotlin.network.RetrofitInstance
import retrofit2.Response

class MainActivityRepository(){

    suspend fun getPictures(aParam: String?): Response<WallpaperResp> {
        return RetrofitInstance.wallpeperApi.getServices(aParam)
    }

  /*  private var wallpaperListSource: WallpaperListSource? = null

    init {
        wallpaperListSource = WallpaperListSource()
    }

    override suspend fun getServicesApiCall(): WallpaperResp? {
        val data = wallpaperListSource?.getServicesApiCall()
        Log.e("data", "getServicesApiCall: "+data )
        return data
    }*/
}