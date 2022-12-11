package com.mvvm.mvvmlearnkotlin.repository
import com.mvvm.mvvmlearnkotlin.dao.WallpaperDao
import com.mvvm.mvvmlearnkotlin.network.ApiService
import com.mvvm.mvvmlearnkotlin.ui.dashboard.ui.Wallpaper.WallpaperViewModel
import com.mvvm.mvvmlearnkotlin.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow



import javax.inject.Inject

class WallpaperRepository @Inject constructor(private val apiService: ApiService, private val wallpaperDao: WallpaperDao){

    suspend fun getWallpaper()  = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.getWallpapers()


        emit(NetworkResult.Success(response.body()))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }



//    suspend fun getUsers(): Resource<WallpaperResponse?> {
//        return wallpaperSource.getWallpaperData()
//    }
}