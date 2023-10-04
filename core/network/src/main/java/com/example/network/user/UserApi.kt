package com.example.network.user

import com.example.network.user.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {

    @GET("users/{id}")
    suspend fun getUserById(
        @Path(value = "id")
        id: String
    ): UserDto
}
