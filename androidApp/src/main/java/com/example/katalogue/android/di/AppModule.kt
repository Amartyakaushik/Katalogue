package com.example.katalogue.android.di


import com.example.katalogue.dataLayer.api.ApiService
import com.example.katalogue.dataLayer.api.ApiServiceImpl
import com.example.katalogue.dataLayer.repository.ProductRepository
import com.example.katalogue.dataLayer.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApiService(): ApiService = ApiServiceImpl()

    @Provides
    fun provideProductRepository(apiService: ApiService): ProductRepository =
        ProductRepositoryImpl(apiService)
}