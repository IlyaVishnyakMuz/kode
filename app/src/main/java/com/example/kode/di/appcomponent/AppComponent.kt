package com.example.todotimer.di.appcomponent

import com.example.kode.di.api.ApiModule
import com.example.kode.screens.MainActivity
import com.example.todotimer.di.common.android.AndroidModule
import com.example.todotimer.di.interactor.InteractorModule
import com.example.todotimer.di.repo.RepoModule
import com.example.todotimer.di.screens.main.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidModule::class,
        InteractorModule::class,
        RepoModule::class,
        ApiModule::class,
        MainModule::class,
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}
