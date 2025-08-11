package com.example.todotimer.di.repo

import com.example.data.repo.users.DefaultUsersRepo
import com.example.data.repo.users.UsersApi
import com.example.domain.interactor.UsersRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepoModule {

    @Provides
    @Singleton
    internal fun provideRepo(
        api: UsersApi
    ): UsersRepo = DefaultUsersRepo(api)
}
