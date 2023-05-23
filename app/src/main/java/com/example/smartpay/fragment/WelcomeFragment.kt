package com.example.smartpay.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.smartpay.R
import com.example.smartpay.databinding.FragmentOnBoardingDesignBinding
import com.example.smartpay.databinding.FragmentWelcomeBinding
import com.example.smartpay.fragment.WelcomeFragment.Companion.MAX_STEP
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER private const val ARG_PARAM1 = "param1" private const val ARG_PARAM2 = "param2" /** * A simple [Fragment] subclass. * Use the [OnBoardingFragment.newInstance] factory method to * create an instance of this fragment. */
class WelcomeFragment : BaseFragment(){
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState
        )
        binding.viewPager2.adapter = OnbBoardingViewAdapter()
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position -> }.attach()
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == MAX_STEP - 1) {
                    binding.btnNext.text =
                        getString(R.string.on_boarding_get_started)
                    //"Get Started"
                    binding.btnNext.contentDescription =
                        getString(R.string.on_boarding_get_started)
                } else {
                    binding.btnNext.text =
                        getString(R.string.on_boarding_next)
                    //"Next"
                    binding.btnNext.contentDescription = getString(R.string.on_boarding_next)
                    //"Next"
                }
            }
        })
        binding.btnSkip.setOnClickListener {
//            activity?.let {
//                val intent = Intent(it, Login::class.java)
//                it.startActivity(intent)
//            }
            navigate(NavigationCommand.To(actionWelcomeFragmentToLoginFragment()))
        }
        binding.btnNext.setOnClickListener {
            if (binding.btnNext.text.toString() == getString(R.string.on_boarding_get_started)) {
//                activity?.let {
//                    val intent = Intent(it, Login::class.java)
//                    it.startActivity(intent)
//                }
                navigate(NavigationCommand.To(actionWelcomeFragmentToLoginFragment()))
            } else {
                val current = (binding.viewPager2.currentItem) + 1
                binding.viewPager2.currentItem = current
                if (current >= MAX_STEP - 1) {
                    binding.btnNext.text = getString(R.string.on_boarding_get_started)
                    binding.btnNext.contentDescription =
                        getString(R.string.on_boarding_get_started)
                } else {
                    binding.btnNext.text = getString(R.string.on_boarding_next)
                    binding.btnNext.contentDescription =
                        getString(R.string.on_boarding_next)
                }
            }
        }
    }

    private fun actionWelcomeFragmentToLoginFragment() : NavDirections{
        return  ActionOnlyNavDirections(R.id.action_welcomeFragment_to_loginFragment)
    }

    companion object {
        const val MAX_STEP = 2
    }
}

class OnbBoardingViewAdapter : RecyclerView.Adapter<PagerVH2>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH2 {
        return PagerVH2(
            FragmentOnBoardingDesignBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PagerVH2, position: Int) = holder.itemView.run {
        with(holder) {
            if (position == 0) {
                bindingDesign.onBoardingTitle.text =
                    context.getString(R.string.heading_one)
                bindingDesign.onBoardingDescription.text = context.getString(R.string.desc_one)
                bindingDesign.onBoardingImage.setImageResource(R.drawable.device)
            }
            if (position == 1) {
                bindingDesign.onBoardingTitle.text =
                    context.getString(R.string.heading_two)
                bindingDesign.onBoardingDescription.text = context.getString(R.string.desc_two)
                bindingDesign.onBoardingImage.setImageResource(R.drawable.image)
            }
        }
    }

    override fun getItemCount(): Int = MAX_STEP
}

class PagerVH2(val bindingDesign: FragmentOnBoardingDesignBinding) :
    RecyclerView.ViewHolder(bindingDesign.root)
