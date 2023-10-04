package com.example.user.domain

import com.example.user.data.User
import javax.inject.Inject

internal class GetUserByUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
): GetUserByIdUseCase {
    override suspend fun execute(id: Int): User {
        return userRepository.getUser(id.toString())
    }
}
