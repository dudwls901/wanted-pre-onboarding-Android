package com.yeongjin.news.data.remote

import android.util.Log
import com.yeongjin.news.BuildConfig
import com.yeongjin.news.data.remote.api.NewsApi
import com.yeongjin.news.global.Constants.baseURL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException
import java.util.concurrent.TimeUnit

object ApiRequestFactory {

    val newsApiService: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildOkHttpClient())
            .build()
    }

    //로깅 + 헤더
    @JvmStatic
    private fun buildOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .connectTimeout(5,TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(APIHeaderInterceptor())
            .build()
    }

    class APIHeaderInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest =
                chain.request().newBuilder().addHeader("X-Api-Key", BuildConfig.NEWS_API_KEY).build()
            return chain.proceed(newRequest)
        }
    }
}