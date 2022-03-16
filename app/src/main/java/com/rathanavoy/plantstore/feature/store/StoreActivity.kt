package com.rathanavoy.plantstore.feature.store

import androidx.fragment.app.Fragment
import com.rathanavoy.plantstore.core.ContainerActivity

class StoreActivity : ContainerActivity() {

    override fun getFragment(): Fragment = StoreFragment()

}