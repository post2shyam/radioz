package com.androidz.radioz.system

import android.app.Application
import com.androidz.radioz.BuildConfig
import timber.log.Timber

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        enableLogger()
    }

    private fun enableLogger() {
        val timberTree = if (BuildConfig.DEBUG) AppDebugTree() else AppReleaseTree()
        Timber.plant(timberTree)
    }
}