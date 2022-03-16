package com.rathanavoy.plantstore.util.extension

import android.app.Activity
import android.util.DisplayMetrics

fun Activity.getScreenWidth(): Int {
    val displayMetrics = DisplayMetrics()
    return windowManager.defaultDisplay.getMetrics(displayMetrics).run {
        displayMetrics.widthPixels
    }
}