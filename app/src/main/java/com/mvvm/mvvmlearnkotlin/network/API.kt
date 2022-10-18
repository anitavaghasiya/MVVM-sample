package com.mvvm.mvvmlearnkotlin.network


import com.mvvm.mvvmlearnkotlin.model.WallpaperResp
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

   /* @POST("photos")
    suspend fun getServices(@Query("client_id" aParam: String?): Response<LoginResponse>*/

    @GET("photos")
    suspend fun getServices(@Query("client_id") aParam: String?) : Response<WallpaperResp>

    fun getData(): ArrayList<String?>? {
        return ArrayList()
    }

}