package com.techhustlers.visitassignment.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techhustlers.visitassignment.ui.weekly.WeeklyFragment
import com.techhustlers.visitassignment.databinding.FragmentHomeBinding
import com.techhustlers.visitassignment.ui.daily.DailyFragment


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {


        //Set up the view pager and fragments

        val adapter = PageAdapter(childFragmentManager)
        adapter.addFragment(DailyFragment(), "Daily")
        adapter.addFragment(WeeklyFragment(), "Weekly")
        adapter.addFragment(WeeklyFragment(), "Monthly")

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager, true)

    }


}