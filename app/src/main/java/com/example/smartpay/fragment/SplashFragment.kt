package com.example.smartpay.fragment

import android.os.Bundle
import android.os.Handler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentSplashBinding


class SplashFragment : BaseFragment() {
    // TODO: Rename and change types of parameters

    private var _binding: FragmentSplashBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleSplashDelay()

    }

    private fun handleSplashDelay() {
        if (binding.imageView != null) {
            binding.imageView.animation = AnimationUtils.loadAnimation(mainActivity, R.anim.splash_image_anim)
        }
        Handler().postDelayed({
            navigate(NavigationCommand.To(actionSplashFragmentToWelcomeFragment()))
        }, SPLASH_TIME_OUT.toLong())
    }

    private fun actionSplashFragmentToWelcomeFragment() : NavDirections{
        return ActionOnlyNavDirections(R.id.action_splashFragment_to_welcomeFragment)
    }

    companion object {
        private const val SPLASH_TIME_OUT = 3000
    }
}