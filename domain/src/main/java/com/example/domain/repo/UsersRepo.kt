package com.example.domain.interactor

import com.example.domain.repo.entity.UsersData

interface UsersRepo {

    suspend fun get(): List<UsersData>
}
