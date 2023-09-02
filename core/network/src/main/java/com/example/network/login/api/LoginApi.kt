package com.example.network.login.api

import com.example.network.login.dto.UserLoginDto
import com.example.network.login.dto.UserLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("auth/login")
    suspend fun login(
        @Body
        userLoginDto: UserLoginDto
    ): UserLoginResponse
}
