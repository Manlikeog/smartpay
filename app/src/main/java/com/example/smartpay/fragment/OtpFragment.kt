package com.example.smartpay.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.ActionOnlyNavDirections
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentOtpBinding


class OtpFragment : BaseFragment() {

    private var _binding: FragmentOtpBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()

    }

    private fun setListeners(){
        binding.card.setOnClickListener {
            navigate(NavigationCommand.Back)
        }

        binding.confirm.setOnClickListener{
            if(binding.pinView.text?.isEmpty() == true){
                Toast.makeText(context, "Empty Code", Toast.LENGTH_SHORT).show()
            } else {
                navigate(NavigationCommand.To(ActionOnlyNavDirections(R.id.action_otpFragment_to_detailFragment)))
            }
        }

        binding.pinView.doAfterTextChanged {
            if(binding.pinView.text?.isEmpty() == true){
                binding.confirm.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.lightButtonColor,
                        resources.newTheme()
                    )
                )
            } else {
                binding.confirm.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.buttonColor,
                        resources.newTheme()
                    )
                )
            }
        }
    }

    companion object {

    }
}