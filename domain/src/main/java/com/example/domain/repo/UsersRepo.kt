package com.example.domain.interactor

import com.example.domain.repo.entity.User

interface UsersRepo {

    suspend fun get(): List<User>
}
