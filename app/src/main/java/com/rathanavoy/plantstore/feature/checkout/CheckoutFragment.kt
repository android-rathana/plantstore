package com.rathanavoy.plantstore.feature.checkout

import android.os.Bundle
import android.view.View
import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.core.BaseFragment
import com.rathanavoy.plantstore.core.BaseViewModel

class CheckoutFragment :
    BaseFragment<BaseViewModel>(BaseViewModel::class, R.layout.fragment_checkout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}