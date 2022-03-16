package com.rathanavoy.plantstore.intent

import android.content.Context
import android.content.Intent
import com.rathanavoy.plantstore.feature.home.HomeActivity

class HomeIntent : Intent {

    constructor(intent: Intent) : super(intent)

    constructor(context: Context) : super(context, HomeActivity::class.java)

}