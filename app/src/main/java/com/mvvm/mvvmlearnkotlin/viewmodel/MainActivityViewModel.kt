package com.mvvm.mvvmlearnkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mvvm.mvvmlearnkotlin.R
import com.mvvm.mvvmlearnkotlin.app.MyApplication
import com.mvvm.mvvmlearnkotlin.model.WallpaperResp
import com.mvvm.mvvmlearnkotlin.repository.MainActivityRepository
import com.mvvm.mvvmlearnkotlin.utils.Event
import com.mvvm.mvvmlearnkotlin.utils.Resource
import com.mvvm.mvvmlearnkotlin.utils.Utils
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class MainActivityViewModel(app: Application, private val appRepository: MainActivityRepository) : AndroidViewModel(app)  {

    private val _wallpaperResp = MutableLiveData<Event<Resource<WallpaperResp>>>()
    val wallpaperResp:LiveData<Event<Resource<WallpaperResp>>> = _wallpaperResp

    fun loginUser(client_id:String) = viewModelScope.launch {
        login(client_id)
    }

    private suspend fun login(client_id:String) {
        _wallpaperResp.postValue(Event(Resource.Loading()))
        try {
            if (Utils.hasInternetConnection(getApplication<MyApplication>())) {
                val response = appRepository.getPictures(client_id)
                _wallpaperResp.postValue(handlePicsResponse(response))
            } else {
                _wallpaperResp.postValue(Event(Resource.Error(getApplication<MyApplication>().getString(R.string.no_internet_connection))))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    _wallpaperResp.postValue(
                        Event(Resource.Error(
                            getApplication<MyApplication>().getString(
                                R.string.network_failure
                            )
                        ))
                    )
                }
                else -> {
                    _wallpaperResp.postValue(
                        Event(Resource.Error(
                            getApplication<MyApplication>().getString(
                                R.string.conversion_error
                            )
                        ))
                    )
                }
            }
        }
    }

    private fun handlePicsResponse(response: Response<WallpaperResp>): Event<Resource<WallpaperResp>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Event(Resource.Success(resultResponse))
            }
        }
        return Event(Resource.Error(response.message()))
    }
   /* private var _servicesLiveData: MutableLiveData<WallpaperResp?> = MutableLiveData()
    var servicesLiveData: LiveData<WallpaperResp?> = _servicesLiveData
    private var mainActRepo: MainActRepo? = null

    init {
        RetrofitClient.apiInterface
        mainActRepo = MainActivityRepository()
    }

    fun getUser() {

        viewModelScope.launch {
            val data = mainActRepo?.getServicesApiCall()

            withContext(Dispatchers.Main) {
                _servicesLiveData.postValue(data)
            }


        }
    }*/

 }