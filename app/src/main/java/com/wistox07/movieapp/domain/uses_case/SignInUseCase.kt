package com.wistox07.movieapp.domain.uses_case

import com.wistox07.movieapp.data.repository.LoginRepositoryImp
import com.wistox07.movieapp.domain.repository.LoginRepository

class SignInUseCase {
    val repository : LoginRepository = LoginRepositoryImp()
     suspend operator fun invoke(email:String , password:String) = repository.singIn(email,password)

}