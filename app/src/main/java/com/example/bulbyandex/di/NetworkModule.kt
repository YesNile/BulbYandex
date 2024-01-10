package com.example.bulbyandex.di

import dagger.Module
import dagger.Provides
import com.example.bulbyandex.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideApiService(): ApiService =
        Retrofit.Builder()
            .baseUrl("http://195.54.14.121:8086/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}