package com.rathanavoy.plantstore.util.extension

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible


fun View.gone() {
    if (!isGone) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (!isVisible) {
        visibility = View.VISIBLE
    }
}