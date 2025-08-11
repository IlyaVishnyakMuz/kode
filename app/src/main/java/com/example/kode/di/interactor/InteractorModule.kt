package com.example.todotimer.di.interactor

import com.example.domain.interactor.GetUsersUseCase
import com.example.domain.interactor.UsersRepo
import dagger.Module
import dagger.Provides

@Module
object InteractorModule {

    @Provides
    fun provideGetUsersUseCase(
        repo: UsersRepo,
    ): GetUsersUseCase = GetUsersUseCase(repo)
}
