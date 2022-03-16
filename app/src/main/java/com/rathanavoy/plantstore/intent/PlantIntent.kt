package com.rathanavoy.plantstore.intent

import android.content.Context
import android.content.Intent
import com.rathanavoy.plantstore.feature.plant.PlantActivity
import com.rathanavoy.plantstore.util.extension.getOrDefault

class PlantIntent : Intent {

    var storeId: String
        get() = getStringExtra(KEY_STORE_ID).getOrDefault()
        set(value) {
            putExtra(KEY_STORE_ID, value)
        }

    constructor(intent: Intent) : super(intent)

    constructor(context: Context, storeId: String) : super(context, PlantActivity::class.java) {
        this.storeId = storeId
    }

    companion object {
        const val KEY_STORE_ID = "STORE_ID"
    }

}