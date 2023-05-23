package com.example.smartpay.fragment

import android.content.res.Resources.Theme
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.ActionOnlyNavDirections
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentSignUpBinding


class SignUpFragment : BaseFragment() {
    private var _binding: FragmentSignUpBinding? = null

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
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpTitle.text = headerTitle(binding.signUpTitle.text, 9, 18)
        setListeners()
    }



    private fun setListeners(){
        binding.card.setOnClickListener {
            navigate(NavigationCommand.Back)
        }
        binding.signIn.setOnClickListener{
            navigate(NavigationCommand.Back)
        }


        binding.email.doAfterTextChanged {
            if(binding.email.text?.isEmpty() == true){
                binding.signUp.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.lightButtonColor,
                        resources.newTheme()
                    )
                )
            } else {
                binding.signUp.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.buttonColor,
                        resources.newTheme()
                    )
                )
            }
        }

        binding.signUp.setOnClickListener {
            if(isValidEmail(binding.email, binding.emailLayout)){
                    navigate(NavigationCommand.To(ActionOnlyNavDirections(R.id.action_signupFragment_to_otpFragment)))
            }


        }


    }
    companion object {

    }
}