package com.rathanavoy.plantstore.intent

import android.content.Context
import android.content.Intent
import com.rathanavoy.plantstore.feature.plant.PlantDetailActivity

class PlantDetailIntent : Intent {

    constructor(intent: Intent) : super(intent)

    constructor(context: Context) : super(context, PlantDetailActivity::class.java)

}