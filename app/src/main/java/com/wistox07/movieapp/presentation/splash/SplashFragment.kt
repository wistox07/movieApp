package com.wistox07.movieapp.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.wistox07.movieapp.R
import com.wistox07.movieapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private val SPLASH_TIME_OUT : Long = 4000
    private lateinit var binding : FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        goToLogin()


    }

    private fun goToLogin(){
        Handler(Looper.getMainLooper()).postDelayed({
            Navigation.findNavController(binding.root).navigate(R.id.action_splashFragment_to_loginFragment)
        },SPLASH_TIME_OUT)
    }
}