package com.mvvm.mvvmlearnkotlin.ui.dashboard.ui.Wallpaper


import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.mvvm.mvvmlearnkotlin.model.WallpaperResponse
import com.mvvm.mvvmlearnkotlin.repository.WallpaperRepository
import com.mvvm.mvvmlearnkotlin.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WallpaperViewModel @Inject constructor(private val wallpaperRepository: WallpaperRepository) : ViewModel(),LifecycleObserver {

    private val _wallpaperResponse:MutableLiveData<NetworkResult<WallpaperResponse?>> = MutableLiveData()
    val wallpaperResponse: LiveData<NetworkResult<WallpaperResponse?>> = _wallpaperResponse

    init {
        getWallpapers()
    }

    fun getWallpapers()  {
       /* viewModelScope.launch {
            _wallpaperResponse.postValue(Resource.loading(data = null))
            try {
                // Log.e("data", "getUsers: "+mainRepository.getUsers("w_dCwgRHHnaqcdt7Y9XXo82ZEBHLcpYB2S2kKhM0WF8"))
                val wallpaper = wallpaperRepository.getUsers()

                withContext(Dispatchers.Main){
                    _wallpaperResponse.postValue(wallpaper)
                }
            } catch (exception: Exception) {
                withContext(Dispatchers.Main){
                    _wallpaperResponse.postValue(Resource.error(null,message = exception.message.toString()))
                }

            }
        }*/

        viewModelScope.launch {
            wallpaperRepository.getWallpaper().collect {
                _wallpaperResponse.postValue(it)
            }
        }

    }
}
