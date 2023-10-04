package com.example.user.domain

import com.example.network.user.UserApi
import com.example.user.data.User
import com.example.user.data.UserMapper
import javax.inject.Inject

internal class UserRepository @Inject constructor(
    private val userApi: UserApi,
    private val userMapper: UserMapper
) {

    suspend fun getUser(id: String): User {
        val userDto = userApi.getUserById(id)
        return userMapper.map(userDto)
    }
}
