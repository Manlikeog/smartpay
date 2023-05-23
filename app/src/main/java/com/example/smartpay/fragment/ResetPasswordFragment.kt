package com.example.smartpay.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentResetPasswordBinding
import com.example.smartpay.databinding.FragmentVerifyBinding


class ResetPasswordFragment : BaseFragment() {

    private var _binding: FragmentResetPasswordBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResetPasswordBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.card.setOnClickListener {
            navigate(NavigationCommand.Back)
        }
    }

    companion object {

    }
}