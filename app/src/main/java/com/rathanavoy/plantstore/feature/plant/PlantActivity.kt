package com.rathanavoy.plantstore.feature.plant

import androidx.fragment.app.Fragment
import com.rathanavoy.plantstore.core.ContainerActivity

class PlantActivity : ContainerActivity() {

    override fun getFragment(): Fragment = PlantFragment()

}