package com.example.todotimer.di.screens.main

import com.example.domain.interactor.GetUsersUseCase
import com.example.kode.screens.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
object MainModule {

    @Provides
    fun provideMainViewModelFactory(
        useCase: GetUsersUseCase,
    ): MainViewModelFactory {
        return MainViewModelFactory(
            useCase = useCase
        )
    }
}
