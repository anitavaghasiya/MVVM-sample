package com.mvvm.mvvmlearnkotlin.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.mvvmlearnkotlin.api.ApiHelper
import com.mvvm.mvvmlearnkotlin.main.viewmodel.MainViewModel
import com.mvvm.mvvmlearnkotlin.repository.MainRepository

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

