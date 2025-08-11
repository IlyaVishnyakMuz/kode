package com.example.data.repo.users

import com.google.gson.annotations.SerializedName

data class ApiResponse<T> (
    @SerializedName("items")
    val users: List<T>,
)
