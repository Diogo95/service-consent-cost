package com.apps.test

import android.app.Application
import com.usercentrics.sdk.Usercentrics
import com.usercentrics.sdk.UsercentricsOptions
import com.usercentrics.sdk.models.common.UsercentricsLoggerLevel

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize Usercentrics with your configuration
        val settingsId = "gChmbFIdL"
        val options = UsercentricsOptions(settingsId, loggerLevel = UsercentricsLoggerLevel.DEBUG)

        Usercentrics.initialize(this, options)
    }
    
}
