package com.wistox07.movieapp.data.repository

import com.wistox07.movieapp.data.UserDto
import com.wistox07.movieapp.domain.repository.LoginRepository

class LoginRepositoryImp : LoginRepository {
    override fun singIn(email: String, password: String): UserDto {
        TODO("Not yet implemented")
    }

}