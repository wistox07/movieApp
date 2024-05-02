package com.wistox07.movieapp.data

import com.google.gson.annotations.SerializedName


data class LoginDto(
    val status:String,
    val token:String,
    val message:String,
    val data:Data

)

data class Data(
    val user:UserDto,
    @SerializedName("profile_id")
    val profileId: Int
)

data class UserDto(
    val name:String,
    val email:String
)