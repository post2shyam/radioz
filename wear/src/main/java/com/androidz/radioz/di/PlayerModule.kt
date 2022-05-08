package com.androidz.radioz.di

import com.androidz.radioz.data.Player
import com.androidz.radioz.application.MainApplication
import com.androidz.radioz.system.RadioPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object PlayerModule {
    //For every request, return the same player instance
    @ActivityRetainedScoped
    @Provides
    fun providesRadioPlayer(mainApplication: MainApplication): Player {
        return RadioPlayer(mainApplication)
    }
}