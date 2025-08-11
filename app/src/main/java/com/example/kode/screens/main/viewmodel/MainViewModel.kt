package com.example.kode.screens.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactor.GetUsersByDepartmentUseCase
import com.example.domain.interactor.GetUsersUseCase
import com.example.domain.repo.entity.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getUsersByDepartmentUseCase: GetUsersByDepartmentUseCase
) : ViewModel() {

    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex = _selectedTabIndex.asStateFlow()

    private val _users = MutableStateFlow(listOf<User>())
    val users = _users.asStateFlow()

    fun changeSelectedTabIndex(value: Int) {
        _selectedTabIndex.value = value
    }

    fun loadUsers() {
        viewModelScope.launch {
            try {
                _users.value = getUsersUseCase.execute()
            } catch (e: Exception) {
                Log.d("CustomError", "${e.message}")
            }
        }
    }

    fun getUsersByDepartment(department: String?) {
        viewModelScope.launch {
            try {
                if (department == null) {
                    _users.value = getUsersUseCase.execute()
                } else {
                    _users.value = getUsersByDepartmentUseCase.execute(department)
                }
            } catch (e: Exception) {
                Log.d("CustomError", "${e.message}")
            }
        }
    }
}

