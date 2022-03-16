package com.rathanavoy.plantstore.intent

import android.content.Context
import android.content.Intent
import com.rathanavoy.plantstore.feature.store.StoreActivity

class StoreIntent : Intent {

    constructor(intent: Intent) : super(intent)

    constructor(context: Context) : super(context, StoreActivity::class.java)

}