package com.wistox07.movieapp.domain.repository

import com.wistox07.movieapp.data.LoginDto
import com.wistox07.movieapp.data.Result
import com.wistox07.movieapp.data.UserDto

interface LoginRepository {

    //Todas las funcionalidades que quieres recuperar o ejecutar
    suspend fun singIn(email:String, password:String) : Result<LoginDto>

}