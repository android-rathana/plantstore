package com.rathanavoy.plantstore.feature.storage

import androidx.fragment.app.Fragment
import com.rathanavoy.plantstore.core.ContainerActivity

class LocalFileActivity : ContainerActivity() {

    override fun getFragment(): Fragment = LocalFileFragment()

}