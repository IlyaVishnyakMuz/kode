package com.example.kode.di.api

import com.example.data.repo.users.UsersApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideApi(): UsersApi {
        return Retrofit.Builder()
            .baseUrl("https://stoplight.io/mocks/kode-api/trainee-test/331141861/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsersApi::class.java)
    }
}
