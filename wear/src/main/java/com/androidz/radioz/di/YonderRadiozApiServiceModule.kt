package com.androidz.radioz.di

import com.androidz.radioz.BuildConfig
import com.androidz.radioz.network.YonderRadiozApiService
import com.androidz.radioz.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object YonderRadiozApiServiceModule {

    private const val BASE_URL = "https://yonderradioz.herokuapp.com"

    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                this.addInterceptor(httpLoggingInterceptor) // Should always be the last interceptor
            }
        }.build()
    }

    //For every request, return the same Retrofit instance
    @Singleton
    @Provides
    fun providesBackEndServer(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
    }

    @Singleton
    @Provides
    fun providesYonderRadiozApiService(retrofit: Retrofit): YonderRadiozApiService =
        retrofit.create(YonderRadiozApiService::class.java)

    @Singleton
    @Provides
    fun providesRepository(yonderRadiozApiService: YonderRadiozApiService) =
        Repository(yonderRadiozApiService)

}