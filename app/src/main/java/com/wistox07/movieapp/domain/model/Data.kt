package com.wistox07.movieapp.domain.model

import com.google.gson.annotations.SerializedName
import com.wistox07.movieapp.data.DataDto
import com.wistox07.movieapp.data.UserDto

data class Data(
val user: UserDto,
val profileId: Int?
)

fun DataDto.toData() : Data{
    return Data(
        user = user,
        profileId = profileId
    )
}