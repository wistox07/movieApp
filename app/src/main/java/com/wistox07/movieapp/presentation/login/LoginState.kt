package com.wistox07.movieapp.presentation.login

import com.wistox07.movieapp.data.LoginDto
import com.wistox07.movieapp.data.UserDto
import com.wistox07.movieapp.domain.model.User

data class LoginState(
    val loader:Boolean? = false,
    val error:String ?= null,
    val data:User ?= null
)

//loginState deberia trabajar con UserDto
