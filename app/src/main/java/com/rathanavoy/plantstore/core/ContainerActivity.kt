package com.rathanavoy.plantstore.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rathanavoy.plantstore.databinding.ActivityContrainerBinding

abstract class ContainerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContrainerBinding

    abstract fun getFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContrainerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            setupFragment(getFragment())
        }
    }

    private fun setupFragment(fragment: Fragment, tag: String? = null) {
        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentContainer.id, fragment, tag ?: fragment.tag)
            .commit()
    }

}