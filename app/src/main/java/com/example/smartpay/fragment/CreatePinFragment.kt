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
import com.example.smartpay.databinding.FragmentCreatePinBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class CreatePinFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentCreatePinBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCreatePinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pinView.isPasswordHidden = true
        binding.card.setOnClickListener {
            navigate(NavigationCommand.Back)
        }
        binding.pinView.doAfterTextChanged {
            if (binding.pinView.text?.isEmpty() == true) {
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
            if (binding.pinView.text?.isEmpty() == true) {
                Toast.makeText(context, "Empty pin", Toast.LENGTH_SHORT).show()
            } else {
                navigate(NavigationCommand.To(ActionOnlyNavDirections(R.id.action_createPinFragment_to_confirmationFragment)))
            }

        }


    }

    companion object {

    }
}