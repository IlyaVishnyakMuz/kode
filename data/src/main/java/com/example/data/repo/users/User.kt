package com.example.data.repo.users

import com.example.domain.repo.entity.UsersData
import com.google.gson.annotations.SerializedName

data class User(
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
    fun toDomain(): UsersData = UsersData(
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
