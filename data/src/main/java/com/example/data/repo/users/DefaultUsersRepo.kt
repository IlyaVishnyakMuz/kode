package com.example.data.repo.users

import com.example.domain.interactor.UsersRepo
import com.example.domain.repo.entity.UsersData

class DefaultUsersRepo(
    private val api: UsersApi
): UsersRepo {

    override suspend fun get(): List<UsersData> {
        val response = api.getUsers()
        return response.users.map { it.toDomain() }
    }
}
