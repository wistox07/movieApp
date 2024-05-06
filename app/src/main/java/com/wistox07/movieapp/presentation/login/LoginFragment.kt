package com.wistox07.movieapp.presentation.login

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wistox07.movieapp.R
import com.wistox07.movieapp.data.Api
import com.wistox07.movieapp.data.LoginDto
import com.wistox07.movieapp.data.LoginRequest
import com.wistox07.movieapp.databinding.FragmentLoginBinding
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnSingIn.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            val request = Api.build().singIn(LoginRequest(email, password))
            request.enqueue(object : Callback<LoginDto> {
                override fun onResponse(call: retrofit2.Call<LoginDto>, response: Response<LoginDto>){
                    if(response.isSuccessful){
                        val loginDto = response.body()
                        loginDto?.let {
                            println(it.data.user)
                        }
                    }else{
                        println(response.message())
                    }
                }

                override fun onFailure(call: retrofit2.Call<LoginDto>, t: Throwable) {
                    println(t.message)
                }

            })


        }
    }
}