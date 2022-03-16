package com.rathanavoy.plantstore.util.extension

import android.content.Context
import androidx.annotation.DimenRes

fun Context.getDimen(@DimenRes id: Int): Int = resources.getDimensionPixelOffset(id)
