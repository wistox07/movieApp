package com.wistox07.movieapp.presentation.login

import com.wistox07.movieapp.data.LoginDto

data class LoginState(
    val loader:Boolean? = false,
    val error:String ?= null,
    val user:LoginDto ?= null
)
