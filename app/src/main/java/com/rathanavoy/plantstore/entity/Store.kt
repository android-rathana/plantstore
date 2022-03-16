package com.rathanavoy.plantstore.entity

import androidx.annotation.DrawableRes

data class Store(
    val id: String,
    val name: String,
    val address: String,
    val description: String,
    val rating: Float,
    @DrawableRes
    val thumb: Int
)