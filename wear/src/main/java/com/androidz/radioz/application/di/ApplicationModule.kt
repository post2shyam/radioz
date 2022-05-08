package com.androidz.radioz.application.di

import android.content.Context
import com.androidz.radioz.application.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Singleton
    @Provides
    fun providesApplication(@ApplicationContext appContext: Context): MainApplication =
        appContext as MainApplication
}