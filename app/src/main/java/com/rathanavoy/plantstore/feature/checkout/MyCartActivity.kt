package com.rathanavoy.plantstore.feature.checkout

import androidx.fragment.app.Fragment
import com.rathanavoy.plantstore.core.ContainerActivity

class MyCartActivity : ContainerActivity() {

    override fun getFragment(): Fragment = MyCartFragment()

}