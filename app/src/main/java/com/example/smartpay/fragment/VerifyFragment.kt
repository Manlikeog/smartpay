package com.example.smartpay.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ActionOnlyNavDirections
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentOtpBinding
import com.example.smartpay.databinding.FragmentVerifyBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VerifyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VerifyFragment : BaseFragment() {

    private var _binding: FragmentVerifyBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVerifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.verifyIdentitySubHeading.text = headerTitle(binding.verifyIdentitySubHeading.text, 20, 29)
        binding.email.setText("A******(@gmail.com")
        binding.continueButton.setOnClickListener {
            navigate(NavigationCommand.To(ActionOnlyNavDirections(R.id.action_verifyIdentityFragment_to_resetPasswordFragment)))
        }
    }
    companion object {

    }
}