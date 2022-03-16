package com.rathanavoy.plantstore.core

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass
import org.koin.androidx.viewmodel.ext.android.getViewModel

abstract class BaseFragment<VM : BaseViewModel>(clazz: KClass<VM>, @LayoutRes layoutRes: Int) :
    Fragment(layoutRes) {

    protected open val viewModel: VM by lazy { getViewModel(clazz = clazz) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    protected fun showToastMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}