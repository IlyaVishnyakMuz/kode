package com.example.kode.screens.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.interactor.GetUsersUseCase

class MainViewModelFactory(
    private val useCase: GetUsersUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                useCase
            ) as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }
}
