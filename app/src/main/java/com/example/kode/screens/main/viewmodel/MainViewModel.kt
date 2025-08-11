package com.example.kode.screens.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactor.GetUsersUseCase
import com.example.domain.repo.entity.UsersData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    val usecase: GetUsersUseCase
) : ViewModel() {

    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex = _selectedTabIndex.asStateFlow()

    private val _state = MutableStateFlow(UserState())
    val state = _state.asStateFlow()

    fun changeSelectedTabIndex(value: Int) {
        _selectedTabIndex.value = value
    }

    fun loadUsers() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val users = usecase.execute()
                _state.value = UserState(users = users)
            } catch (e: Exception) {
                Log.d("CustomError", "${e.message}")
            } finally {
                _state.value = _state.value.copy(isLoading = false)
            }
        }
    }
}

data class UserState(
    val users: List<UsersData> = emptyList(),
    val isLoading: Boolean = false,
)
