package com.example.user.data

import com.example.network.user.dto.UserDto
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun map(userDto: UserDto): User {
        return User(
            id = userDto.id,
            username = userDto.username,
        )
    }
}
