package com.androidz.radioz.data

import java.io.Closeable

interface Player : Closeable {
    fun open(): Unit
    fun setUrl(url: String): Unit
    fun play(): Unit
    fun stop(): Unit
}