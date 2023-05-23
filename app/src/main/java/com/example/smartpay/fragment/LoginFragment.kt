package com.example.smartpay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : BaseFragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.signUp.setOnClickListener {
            navigate(NavigationCommand.To(actionLoginFragmentToSignupFragment()))
        }
        binding.card.setOnClickListener {
            navigate(NavigationCommand.Back)
        }

        binding.forgotPassword.setOnClickListener {
            navigate(NavigationCommand.To(ActionOnlyNavDirections(R.id.action_loginFragment_to_forgotPasswordFragment)))
        }

        binding.signIn.setOnClickListener {

            binding.usernameLayout.isErrorEnabled = false
            binding.passwordLayout.isErrorEnabled = false

            validateData()
        }
    }

    private fun actionLoginFragmentToSignupFragment(): NavDirections {
        return ActionOnlyNavDirections(R.id.action_loginFragment_to_signupFragment)
    }

    private fun validateData() {
        email = binding.username
        password = binding.password
        emailLayout = binding.usernameLayout
        passwordLayout = binding.passwordLayout


        if (isValidEmail(email, emailLayout) && isValidPassword(password, passwordLayout)) {
        }
    }






    companion object {
        lateinit var passwordError: String
        private lateinit var email: TextInputEditText
        private lateinit var password: TextInputEditText
        private lateinit var emailLayout: TextInputLayout
        private lateinit var passwordLayout: TextInputLayout
    }
}