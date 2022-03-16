package com.rathanavoy.plantstore.feature.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rathanavoy.plantstore.core.ContainerActivity

class HomeActivity : ContainerActivity() {

    override fun getFragment(): Fragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}