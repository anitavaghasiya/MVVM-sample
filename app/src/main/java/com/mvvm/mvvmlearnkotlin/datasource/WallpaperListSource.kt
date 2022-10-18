package com.mvvm.mvvmlearnkotlin.datasource

import com.mvvm.mvvmlearnkotlin.model.WallpaperResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class WallpaperListSource:IWallpaperListSource {

//    override suspend fun getServicesApiCall(): WallpaperResp {
//        var urlList = mutableListOf<WallpaperResp>()
//        val call = RetrofitClient.apiInterface.getServices("w_dCwgRHHnaqcdt7Y9XXo82ZEBHLcpYB2S2kKhM0WF8")
//
//        call.enqueue(object: Callback<WallpaperResp> {
//            override fun onResponse(call: Call<WallpaperResp>, response: Response<WallpaperResp>) {
//                urlList=response.body().
//            }
//
//            override fun onFailure(call: Call<WallpaperResp>, t: Throwable) {
//
//            }
//        })
//        return WallpaperResp(response)
//
//    }


//}