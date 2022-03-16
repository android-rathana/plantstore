package com.rathanavoy.plantstore.feature.home

import android.os.Bundle
import android.view.View
import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.core.BaseFragment
import com.rathanavoy.plantstore.core.BaseViewModel
import com.rathanavoy.plantstore.databinding.FragmentHomeBinding
import com.rathanavoy.plantstore.intent.LocalFileIntent
import com.rathanavoy.plantstore.intent.StoreIntent

class HomeFragment : BaseFragment<BaseViewModel>(BaseViewModel::class, R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.btnGo.setOnClickListener {
            startActivity(StoreIntent(requireContext()))
        }
    }

}