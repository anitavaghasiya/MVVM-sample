package com.mvvm.mvvmlearnkotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WallpaperApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}