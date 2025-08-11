package com.example.data.repo.users

import retrofit2.http.GET

interface UsersApi {

    @GET("users")
    suspend fun getUsers(): ApiResponse<User>
}
