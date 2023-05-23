package com.example.smartpay.adapter

import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentDetailBinding
import com.example.smartpay.fragment.BaseFragment
import com.example.smartpay.model.country.CountryData
import com.google.android.material.bottomsheet.BottomSheetDialog

class CountryListAdapter (private val context : Context, private val transList : List<CountryData>, private val sheetDialog: BottomSheetDialog, private val binding: FragmentDetailBinding) : RecyclerView.Adapter<CountryListAdapter.MyViewHolder>(){


    var selectedCountry = -1
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var abb : TextView
        var country : TextView
        var flag : ImageView
        var tick: ImageView

        init {

            abb = view.findViewById(R.id.abbreviation)
            country = view.findViewById(R.id.country)
            flag = view.findViewById(R.id.flag)
            tick = view.findViewById(R.id.tick)
        }
    }

    override fun getItemCount(): Int {
        return transList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = transList[position]
        holder.abb.text = item.abbreviation
        holder.country.text = item.country
        holder.flag.setImageDrawable(item.flag)
        if(selectedCountry ==position){
            holder.itemView.setBackgroundResource(R.drawable.custom_edittext)

            holder.tick.visibility = View.VISIBLE }
        else {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.tick.visibility = View.INVISIBLE
        }
        holder.itemView.setOnClickListener {
            selectedCountry = position
            Toast.makeText(context, item.abbreviation, Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                sheetDialog.dismiss()
            }, 300)
            binding.providerFilledExposedDropdown.setText(item.country)

            binding.selectCountry.setStartIconDrawable(item.flag)
            notifyDataSetChanged()
        }




    }



    companion object {

    }
}