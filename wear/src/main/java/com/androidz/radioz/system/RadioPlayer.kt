package com.androidz.radioz.system

import android.content.Context
import com.androidz.radioz.data.Player
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.MediaSourceFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource

class RadioPlayer(private val context: Context) : Player {

    private lateinit var simpleExoPlayer: ExoPlayer

    private lateinit var mediaDataSourceFactory: DataSource.Factory

    override fun open() {
        mediaDataSourceFactory = DefaultDataSource.Factory(context)

        val mediaSourceFactory: MediaSourceFactory =
            DefaultMediaSourceFactory(mediaDataSourceFactory)

        simpleExoPlayer = ExoPlayer.Builder(context)
            .setMediaSourceFactory(mediaSourceFactory)
            .build()
    }

    override fun setUrl(radioUri: String) {
        val mediaSource = ProgressiveMediaSource.Factory(mediaDataSourceFactory)
            .createMediaSource(MediaItem.fromUri(radioUri))
        simpleExoPlayer.addMediaSource(mediaSource)
        simpleExoPlayer.prepare()
    }

    override fun play() {
        simpleExoPlayer.playWhenReady = true
    }

    override fun stop() {
        simpleExoPlayer.playWhenReady = false
    }

    override fun close() {
        stop()
    }
}