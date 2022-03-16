package com.rathanavoy.plantstore.intent

import android.content.Context
import android.content.Intent
import com.rathanavoy.plantstore.feature.storage.LocalFileActivity

class LocalFileIntent : Intent {

    constructor(intent: Intent) : super(intent)

    constructor(context: Context) : super(context, LocalFileActivity::class.java)

}