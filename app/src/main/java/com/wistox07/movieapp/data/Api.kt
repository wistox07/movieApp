package com.wistox07.movieapp.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
//object es singleton
object Api {
    private val buider: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("http://192.168.18.5")
        .addConverterFactory(GsonConverterFactory.create())

    //suspecion de funcion hasta que se devuelva la data suspend
    //Response porque ya no espero un callback
    interface  RemoteService{
        @POST("api_movie/public/api/auth/login")
        suspend fun singIn(@Body request: LoginRequest) : Response<LoginDto>
    }

    fun build() : RemoteService{
        return buider.build().create(RemoteService::class.java)
    }


}