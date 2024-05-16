package com.wistox07.movieapp.data.repository

import com.wistox07.movieapp.data.Api
import com.wistox07.movieapp.data.LoginDto
import com.wistox07.movieapp.data.LoginRequest
import com.wistox07.movieapp.data.Result
import com.wistox07.movieapp.data.UserDto
import com.wistox07.movieapp.domain.repository.LoginRepository
import java.io.IOException

class LoginRepositoryImp : LoginRepository {
    override suspend fun singIn(email: String, password: String): Result<LoginDto> {
        /*val response = Api.build().singIn(LoginRequest(email, password))
        if (response.body()?.status == "success") {
            return Result.Success(response.body())
        } else {
            return Result.Error(message = response.body()?.message!!)
        }*/

        return try {

            val response = Api.build().singIn(LoginRequest(email, password))
            if (response.body()?.status == "success") {
                Result.Success(response.body())
            } else {
                Result.Error(message = response.body()?.message!!)
            }
        } catch (ex: IOException) {
            Result.Error(message = "Verifica tu conexion a Internet")
        } catch (ex: Exception) {
            Result.Error(message = ex.message!!)
        }


    }

}