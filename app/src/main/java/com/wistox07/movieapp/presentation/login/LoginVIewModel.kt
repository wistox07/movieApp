package com.wistox07.movieapp.presentation.login

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wistox07.movieapp.data.Api
import com.wistox07.movieapp.data.LoginDto
import com.wistox07.movieapp.data.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginVIewModel : ViewModel(){
    //STATES
    //LIVEDATE Y MUTABLEVIEWDATA
    val _loader = MutableLiveData<Boolean>()
    val _success = MutableLiveData<LoginDto>()
    val _error = MutableLiveData<String>()

    private val _state = MutableLiveData<LoginState>()
    val state : LiveData<LoginState> = _state
    fun singIn(email:String , password:String){

        //COROUTINES
        //GlobalScope espera aunque te muevas de fragment
        //viewMOdelScope
        viewModelScope.launch() {
            try{

                _state.value = LoginState().copy(loader = true)
                val response = withContext(Dispatchers.IO){
                    Api.build().singIn(LoginRequest(email,password))
                }

                if(response.isSuccessful) {
                    val loginRemote = response.body()
                    loginRemote?.let {user ->
                        _state.value = LoginState().copy(user = user)
                    }
                }
            }catch (ex:java.lang.Exception){
                println(ex.message)
            }finally {
                _state.value = LoginState().copy(loader = false)
            }
        }
    }

}