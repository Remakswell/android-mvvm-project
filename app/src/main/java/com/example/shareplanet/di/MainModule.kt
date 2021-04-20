package com.example.shareplanet.di

import com.example.shareplanet.data.DataRepository
import com.example.shareplanet.data.local.LocalDataSource
import com.example.shareplanet.data.network.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideRepository(
        localDataSource: LocalDataSource,
        networkDataSource: NetworkDataSource
    ): DataRepository {
        return DataRepository(localDataSource, networkDataSource)
    }
}