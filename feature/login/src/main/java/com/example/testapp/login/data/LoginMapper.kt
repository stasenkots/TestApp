package com.example.testapp.login.data

import com.example.network.login.dto.UserLoginResponse
import com.example.testapp.login.data.model.LoginResult
import com.example.testapp.login.data.model.UserData
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

class LoginMapper @Inject constructor() {
    fun mapUserLoginResponse(response: UserLoginResponse): LoginResult {
            return LoginResult.Success(UserData(
                id = response.id,
                email = response.email,
                firstName = response.firstName,
                lastName = response.lastName,
                gender = response.gender,
                image = response.image,
                token = response.token,
                username = response.username
            ))
    }

    fun mapUserLoginError(exception: HttpException): LoginResult {
        val body = exception.response()?.errorBody()?.string().orEmpty()
        val jsonObject = JSONObject(body)
        val errorMessage = jsonObject.optString("message")
        return LoginResult.Error(errorMessage)
    }
}
