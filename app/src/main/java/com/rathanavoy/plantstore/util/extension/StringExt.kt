package com.rathanavoy.plantstore.util.extension

import java.util.Locale

fun formatCurrency(format: String, amount: Double): String {
    return String.format(Locale.US, format, amount)
}

fun String?.getOrDefault(): String {
    return this ?: ""
}