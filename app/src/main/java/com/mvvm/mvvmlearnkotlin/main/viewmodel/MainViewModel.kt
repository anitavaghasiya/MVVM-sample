package com.mvvm.mvvmlearnkotlin.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mvvm.mvvmlearnkotlin.repository.MainRepository
import com.mvvm.mvvmlearnkotlin.utils.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
           // Log.e("datta", "getUsers: "+mainRepository.getUsers("w_dCwgRHHnaqcdt7Y9XXo82ZEBHLcpYB2S2kKhM0WF8"))
            emit(Resource.success(data = mainRepository.getUsers("w_dCwgRHHnaqcdt7Y9XXo82ZEBHLcpYB2S2kKhM0WF8")))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}