package com.example.domain.interactor

import com.example.domain.repo.entity.User

class GetUsersUseCase(
    private val repo: UsersRepo
) {

    suspend fun execute(): List<User> {
        return repo.get()
    }
}
