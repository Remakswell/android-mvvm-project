package com.example.template.di

import com.example.template.data.DataRepository
import com.example.template.data.local.LocalDataSource
import com.example.template.data.network.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
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