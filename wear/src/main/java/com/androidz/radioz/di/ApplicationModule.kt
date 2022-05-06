package com.androidz.radioz.di

import android.content.Context
import com.androidz.radioz.BuildConfig
import com.androidz.radioz.system.AppDebugTree
import com.androidz.radioz.system.AppReleaseTree
import com.androidz.radioz.system.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun providesApplication(@ApplicationContext appContext: Context): MainApplication =
        appContext as MainApplication

    @Singleton
    @Provides
    fun providesTimberTree(): Timber.Tree =
        if (BuildConfig.DEBUG) AppDebugTree() else AppReleaseTree()
}