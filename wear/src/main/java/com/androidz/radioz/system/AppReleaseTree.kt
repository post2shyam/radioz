package com.androidz.radioz.system

import android.util.Log
import timber.log.Timber

class AppReleaseTree : Timber.Tree() {
    private val tag = "RADIOZ: "
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        when (priority) {
            Log.ASSERT -> Log.wtf(this.tag, message)
            Log.ERROR -> Log.e(this.tag, message)
        }
    }

}
