package com.example.smartpay.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.core.content.res.ResourcesCompat
import androidx.navigation.ActionOnlyNavDirections

import com.example.smartpay.R
import com.example.smartpay.adapter.CountryListAdapter
import com.example.smartpay.databinding.FragmentBottomSheetBinding
import com.example.smartpay.databinding.FragmentDetailBinding
import com.example.smartpay.model.country.CountryData
import com.google.android.material.bottomsheet.BottomSheetDialog


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
class DetailFragment : BaseFragment() {

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!
    private val countryItems = mutableListOf<CountryData>()


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ticketItems()
        setListeners()

        binding.detailHeading.text = headerTitle(binding.detailHeading.text, 30, 39)

    }


    private fun setListeners() {
        binding.card.setOnClickListener {
            navigate(NavigationCommand.Back)
        }

        binding.providerFilledExposedDropdown.setOnClickListener {
            val dialog = BottomSheetDialog(mainActivity, R.style.BottomSheetDialogTheme)

            val j = FragmentBottomSheetBinding.inflate(layoutInflater)
            j.ticketRecycler.adapter = CountryListAdapter(mainActivity, countryItems, dialog, binding)
            dialog.setContentView(j.root)

            dialog.show()
        }

        binding.confirm.setOnClickListener{
            navigate(NavigationCommand.To(ActionOnlyNavDirections(R.id.action_detailFragment_to_createPinFragment)))
        }

    }


    private fun ticketItems() {
        var items = CountryData(
            "US",
            "United States",
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.flag,
                resources.newTheme()
            )!!
        )
        countryItems.add(items)

        items = CountryData(
            "GB",
            "United Kingdom",
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.uk,
                resources.newTheme()
            )!!
        )
        countryItems.add(items)

        items = CountryData(
            "SG",
            "Singapore",
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.sg,
                resources.newTheme()
            )!!
        )
        countryItems.add(items)

        items = CountryData(
            "CN",
            "China",
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.cn,
                resources.newTheme()
            )!!
        )
        countryItems.add(items)

        items = CountryData(
            "NL",
            "Netherlands",
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.nl,
                resources.newTheme()
            )!!
        )
        countryItems.add(items)

        items = CountryData(
            "ID",
            "Indonesia",
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.id,
                resources.newTheme()
            )!!
        )
        countryItems.add(items)
    }


}