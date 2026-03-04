package com.example.wetherprototype.di

import com.example.wetherprototype.data.repository.LocationRepositoryImpl
import com.example.wetherprototype.data.repository.WeatherRepositoryImpl
import com.example.wetherprototype.domain.repository.LocationRepository
import com.example.wetherprototype.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    @Binds
    @Singleton
    abstract fun bindLocationRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository
}