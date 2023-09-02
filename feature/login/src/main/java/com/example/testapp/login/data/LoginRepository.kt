package com.example.testapp.login.data

import com.example.network.login.api.LoginApi
import com.example.network.login.dto.UserLoginDto
import com.example.testapp.login.data.model.LoginResult
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject


class LoginRepository @Inject constructor(
    private val loginApi: LoginApi,
    private val loginMapper: LoginMapper
) {

    suspend fun login(username: String, password: String): LoginResult {
        return try {
            val userLoginResponse = loginApi.login(UserLoginDto(username, password))
            loginMapper.mapUserLoginResponse(userLoginResponse)
        } catch (e: HttpException) {
            loginMapper.mapUserLoginError(e)
        }
    }
}
