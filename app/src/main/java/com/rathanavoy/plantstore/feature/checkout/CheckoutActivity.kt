package com.rathanavoy.plantstore.feature.checkout

import androidx.fragment.app.Fragment
import com.rathanavoy.plantstore.core.ContainerActivity

class CheckoutActivity : ContainerActivity() {

    override fun getFragment(): Fragment = CheckoutFragment()

}