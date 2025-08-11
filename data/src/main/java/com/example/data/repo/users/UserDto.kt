package com.example.data.repo.users

import com.example.domain.repo.entity.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("avatarUrl")
    val avatarUrl: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("userTag")
    val userTag: String,
    @SerializedName("department")
    val department: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("phone")
    val phone: String
) {
    fun toDomain(): User = User(
        id,
        avatarUrl,
        firstName,
        lastName,
        userTag,
        department,
        position,
        birthday,
        phone
    )
}
