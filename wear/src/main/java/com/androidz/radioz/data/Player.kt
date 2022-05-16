package com.androidz.radioz.data

import java.io.Closeable

interface Player : Closeable {
    fun setUrl(radioUri: String)
    fun play()
    fun stop()
}