package com.mvvm.mvvmlearnkotlin.data.source

import com.mvvm.mvvmlearnkotlin.model.WallpaperResponse
import com.mvvm.mvvmlearnkotlin.network.ApiService
import com.mvvm.mvvmlearnkotlin.utils.ErrorUtils
import com.mvvm.mvvmlearnkotlin.utils.NetResult
import com.mvvm.mvvmlearnkotlin.utils.Resource
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class WallpaperSource(private val apiService: ApiService) {

    suspend fun getWallpaperData():Resource<WallpaperResponse?> {
        val response = apiService.getWallpapers()
        return if (response.isSuccessful){
            Resource.success(response.body())
        }else{
            Resource.error(null,"Something went wrong")
        }
    }

//    suspend fun fetchWallpaperData(): NetResult<WallpaperResponse> {
//       // val movieService = retrofit.create(MovieService::class.java);
//        return getResponse(
//            request = { apiService.getWallpapers() },
//            defaultErrorMessage = "Error fetching Movie list")
//
//    }
//
//    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): NetResult<T> {
//        return try {
//            println("I'm working in thread ${Thread.currentThread().name}")
//            val result = request.invoke()
//            if (result.isSuccessful) {
//                return NetResult.success(result.body())
//            } else {
//                val errorResponse = ErrorUtils.parseError(result, retrofit)
//                NetResult.error(errorResponse?.message ?: defaultErrorMessage, errorResponse)
//            }
//        } catch (e: Throwable) {
//            NetResult.error("Unknown Error", null)
//        }
//    }



}