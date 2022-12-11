package com.mvvm.mvvmlearnkotlin.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mvvm.mvvmlearnkotlin.model.*


/**
 * converts List to and from String
 */
class GenreConverters {

    @TypeConverter
    fun listToJson(value: List<Any>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Any> {
        val listType = object : TypeToken<ArrayList<Any?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    //For User Object
    @TypeConverter
    fun convertUserToJsonString(user: User): String? {
        return Gson().toJson(user)
    }

    @TypeConverter
    fun convertJsonToUser(value: String): User {
        return Gson().fromJson(value, User::class.java)
    }

    ///For Link Object
    @TypeConverter
    fun convertLinkToString(links: Links): String? {
        return Gson().toJson(links)
    }

    @TypeConverter
    fun convertLinksToJsonString(links: String): Links {
        return Gson().fromJson(links, Links::class.java)
    }

    ///For Sponsorship Object
    @TypeConverter
    fun convertSponsorshipToString(sponsorship: Sponsorship): String? {
        return Gson().toJson(sponsorship)
    }

    @TypeConverter
    fun convertSponsorshipToJsonString(sponsorship: String): Sponsorship {
        return Gson().fromJson(sponsorship, Sponsorship::class.java)
    }

    ///For Sponsorship Object
    @TypeConverter
    fun convertTopicSubmissionsToString(topicSubmissions: TopicSubmissions): String? {
        return Gson().toJson(topicSubmissions)
    }

    @TypeConverter
    fun convertTopicSubmissionsToJsonString(topicSubmissions: String): TopicSubmissions {
        return Gson().fromJson(topicSubmissions, TopicSubmissions::class.java)
    }


    ///For Urls Object
    @TypeConverter
    fun convertUrlsToString(urls: Urls): String? {
        return Gson().toJson(urls)
    }

    @TypeConverter
    fun convertUrlsToJsonString(urls: String): Urls {
        return Gson().fromJson(urls, Urls::class.java)
    }

    /*@TypeConverter
    fun fromString(value: String?): ArrayList<String?>? {
        val listType = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }*/


}