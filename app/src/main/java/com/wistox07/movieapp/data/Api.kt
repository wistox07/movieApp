package com.wistox07.movieapp.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class Api {
    private val buider: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("http://192.168.18.5")
        .addConverterFactory(GsonConverterFactory.create())


    interface  RemoteService{
        @POST("api_movie/public/api/auth/login")
        fun singIn(@Body request: LoginRequest) : Call<LoginDto>
    }

    fun build() : RemoteService{
        return buider.build().create(RemoteService::class.java)
    }


}