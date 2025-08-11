package com.example.domain.interactor

import com.example.domain.repo.entity.UsersData

class GetUsersUseCase(
    private val repo: UsersRepo
) {

    suspend fun execute(): List<UsersData> {
        return repo.get()
    }
}
