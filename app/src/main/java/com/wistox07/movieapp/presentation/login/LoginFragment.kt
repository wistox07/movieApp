package com.wistox07.movieapp.presentation.login

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.wistox07.movieapp.R
import com.wistox07.movieapp.data.Api
import com.wistox07.movieapp.data.LoginDto
import com.wistox07.movieapp.data.LoginRequest
import com.wistox07.movieapp.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    val vIewModel : LoginVIewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }


    private fun setupObservers(){
        vIewModel._loader.observe(viewLifecycleOwner){loader ->
            if(loader) binding.progressBar.visibility = View.VISIBLE
            else binding.progressBar.visibility = View.GONE
        }
        vIewModel._success.observe(viewLifecycleOwner){
            println("Bienvenido: ${it.data.user.name} ${it.data.user.email}")
        }
        vIewModel._error.observe(viewLifecycleOwner){error ->
            println(error)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        setupObservers()

        binding.btnSingIn.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            vIewModel.singIn(email,password)
            /*
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
            */
            //COROUTINES
            //GlobalScope espera aunque te muevas de fragment
            /*GlobalScope.launch(Dispatchers.Main) {
                try{
                    binding.progressBar.visibility= View.VISIBLE
                    val response = withContext(Dispatchers.IO){
                        Api.build().singIn(LoginRequest(email,password))
                    }

                    if(response.isSuccessful) {
                        val loginRemote = response.body()
                        loginRemote?.let {
                            println("Bienvenido: ${it.data.user.name} ${it.data.user.email}")
                        }
                    }
                }catch (ex:java.lang.Exception){
                    println(ex.message)
                }finally {
                    binding.progressBar.visibility = View.GONE
                }
            }
            */



        }
    }
}