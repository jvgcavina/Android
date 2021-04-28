package com.jvgc.architecture.mvvm.repository.remote

import com.jvgc.architecture.mvvm.repository.model.Character
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface RetrofitService {

    companion object {
        private const val API_URL = "http://hp-api.herokuapp.com/api/"
        private const val READ_TIMEOUT: Long = 30
        private const val CONNECT_TIMEOUT: Long = 30

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val clientBuilder = OkHttpClient.Builder()
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                val client = clientBuilder.build()
                val retrofit = Retrofit.Builder().baseUrl(API_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

    @GET("characters/")
    fun getAllCharacters() : Call<List<Character>>
}