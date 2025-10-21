package com.arlo.sample

import android.app.Application
import android.util.Log
import com.arlo.sdk.ArloConfig
import com.arlo.sdk.ArloSDK

class SampleApplication : Application() {

    companion object {
        private const val TAG = "SampleApplication"
    }

    override fun onCreate() {
        super.onCreate()

        // Initialize Arlo SDK
        val config = ArloConfig(
            enableLearning = true,
            enableAppOrganization = true,
            enablePhotoManagement = true,
            enableFileOrganization = true,
            enableBackgroundAnalysis = true,
            privacyMode = true,
            debugMode = true // Enable for demo purposes
        )

        ArloSDK.initialize(this, config)
        Log.d(TAG, "Arlo SDK initialized with version: ${ArloSDK.getVersion()}")
    }
}
