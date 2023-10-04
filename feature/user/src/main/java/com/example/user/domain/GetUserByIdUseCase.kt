package com.example.user.domain

import com.example.user.data.User

interface GetUserByIdUseCase {
    suspend fun execute(id: Int): User
}
