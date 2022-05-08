package com.androidz.radioz.system.logger.di

import com.androidz.radioz.BuildConfig
import com.androidz.radioz.system.logger.AppDebugTree
import com.androidz.radioz.system.logger.AppReleaseTree
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoggerModule {
    @Singleton
    @Provides
    fun providesTimberTree(): Timber.Tree =
        if (BuildConfig.DEBUG) AppDebugTree() else AppReleaseTree()
}