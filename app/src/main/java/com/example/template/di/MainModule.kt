package com.example.template.di

import com.example.template.data.DataRepository
import com.example.template.data.local.LocalDataSource
import com.example.template.data.network.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class MainModule {

    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource,
        networkDataSource: NetworkDataSource
    ): DataRepository {
        return DataRepository(localDataSource, networkDataSource)
    }
}