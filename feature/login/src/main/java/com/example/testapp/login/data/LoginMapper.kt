package com.example.testapp.login.data

import com.example.network.login.dto.UserLoginResponse
import com.example.testapp.login.data.model.UserData
import com.example.user.UserProto
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

class LoginMapper @Inject constructor() {
    fun mapUserLoginResponse(response: UserLoginResponse): UserData {
            return UserData(
                id = response.id,
                email = response.email,
                firstName = response.firstName,
                lastName = response.lastName,
                gender = response.gender,
                image = response.image,
                token = response.token,
                username = response.username
            )
    }

    fun mapUserDataToUserData(userProto: UserProto, userData: UserData): UserProto{
        return userProto.toBuilder()
            .setEmail(userData.email)
            .setId(userData.id)
            .setFirstName(userData.firstName)
            .setLastName(userData.lastName)
            .setImage(userData.image)
            .setUsername(userData.username)
            .setToken(userData.token)
            .setGender(userData.gender)
            .build()
    }


    fun mapUserLoginError(exception: HttpException): String {
        val body = exception.response()?.errorBody()?.string().orEmpty()
        val jsonObject = JSONObject(body)
        return jsonObject.optString("message")
    }
}
