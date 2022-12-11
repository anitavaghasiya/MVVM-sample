package com.mvvm.mvvmlearnkotlin.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvvm.mvvmlearnkotlin.dao.WallpaperDao
import com.mvvm.mvvmlearnkotlin.model.WallpaperResponse
import com.mvvm.mvvmlearnkotlin.model.WallpaperResponseItem
import com.mvvm.mvvmlearnkotlin.utils.GenreConverters

@Database(entities = [WallpaperResponseItem::class], version = 1)
@TypeConverters(GenreConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wallpepaperDao(): WallpaperDao

}