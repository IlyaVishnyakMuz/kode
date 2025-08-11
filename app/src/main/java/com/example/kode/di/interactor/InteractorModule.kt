package com.example.todotimer.di.interactor

import com.example.domain.interactor.GetUserUseCase
import com.example.domain.interactor.GetUsersByDepartmentUseCase
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

    @Provides
    fun provideGetUserUseCase(
        repo: UsersRepo,
    ): GetUserUseCase = GetUserUseCase(repo)

    @Provides
    fun provideGetUsersByDepartmentUseCase(
        repo: UsersRepo,
    ): GetUsersByDepartmentUseCase = GetUsersByDepartmentUseCase(repo)
}
