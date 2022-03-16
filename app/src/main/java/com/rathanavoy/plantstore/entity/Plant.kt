package com.rathanavoy.plantstore.entity

import androidx.annotation.DrawableRes

data class Plant(
    val id: String,
    val name: String,
    val category: String,
    val categoryId: String,
    val description: String,
    val price: Double,
    @DrawableRes
    val thumb: Int
)