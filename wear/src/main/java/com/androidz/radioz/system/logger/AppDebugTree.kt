package com.androidz.radioz.system.logger

import timber.log.Timber

class AppDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "${element.fileName}:${element.lineNumber}:${Thread.currentThread().name}"
    }
}
