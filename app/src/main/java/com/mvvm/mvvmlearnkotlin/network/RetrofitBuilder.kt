package com.mvvm.mvvmlearnkotlin.network

import com.mvvm.mvvmlearnkotlin.BuildConfig
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object RetrofitBuilder {
    private fun getRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL).client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
    }

    fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original: Request = chain.request()
                val originalHttpUrl: HttpUrl = original.url

                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("client_id", "w_dCwgRHHnaqcdt7Y9XXo82ZEBHLcpYB2S2kKhM0WF8")
                    .build()

                val requestBuilder: Request.Builder = original.newBuilder().url(url)
                val request: Request = requestBuilder.build()
                return chain.proceed(request)
            }
        })

        return httpClient.build()
    }

    val apiService: ApiService = getRetrofit().build().create(ApiService::class.java)
}