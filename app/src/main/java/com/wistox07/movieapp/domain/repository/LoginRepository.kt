package com.wistox07.movieapp.domain.repository

import com.wistox07.movieapp.data.UserDto

interface LoginRepository {

    //Todas las funcionalidades que quieres recuperar o ejecutar
    fun singIn(email:String, password:String) : UserDto

}