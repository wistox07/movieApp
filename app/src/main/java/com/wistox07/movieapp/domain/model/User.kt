package com.wistox07.movieapp.domain.model

import com.wistox07.movieapp.data.UserDto

data class User(
    val name:String,
    val email:String
)
fun UserDto.toUser() : User{
    return User(
        name = name,
        email = email
    )
}
