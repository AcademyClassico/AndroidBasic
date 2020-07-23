package com.digitalcreative.coronaapps.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://classico.id:1103")
            .client(getOkHTTPClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getOkHTTPClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
    }
}