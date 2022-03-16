package com.rathanavoy.plantstore

import android.app.Application
import com.rathanavoy.plantstore.di.appModule
import com.rathanavoy.plantstore.di.repositoryModule
import com.rathanavoy.plantstore.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PlatStoreApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@PlatStoreApp)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }

}