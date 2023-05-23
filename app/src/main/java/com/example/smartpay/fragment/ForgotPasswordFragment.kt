package com.example.smartpay.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.ActionOnlyNavDirections
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : BaseFragment() {
    private var _binding : FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.email.doAfterTextChanged {
            if(binding.email.text?.isEmpty() == true){
                binding.createPin.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.lightButtonColor,
                        resources.newTheme()
                    )
                )
            } else {
                binding.createPin.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.buttonColor,
                        resources.newTheme()
                    )
                )
            }
        }


        binding.createPin.setOnClickListener {
            if(isValidEmail(binding.email, binding.emailLayout)){
                navigate(NavigationCommand.To(ActionOnlyNavDirections(R.id.action_forgotPasswordFragment_to_passwordRecoveryFragment)))

            } else {
                Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {

    }
}