package com.example.testapp.login.data

import androidx.datastore.core.DataStore
import com.example.network.login.api.LoginApi
import com.example.network.login.dto.UserLoginDto
import com.example.testapp.login.data.model.LoginResult
import com.example.user.UserProto
import retrofit2.HttpException
import javax.inject.Inject


class LoginRepository @Inject constructor(
    private val loginApi: LoginApi,
    private val userProtoStore: DataStore<UserProto>,
    private val loginMapper: LoginMapper
) {

    suspend fun login(username: String, password: String): LoginResult {
        return try {
            val userLoginResponse = loginApi.login(UserLoginDto(username, password))
            val userData = loginMapper.mapUserLoginResponse(userLoginResponse)
            userProtoStore.updateData { userProto ->
                loginMapper.mapUserDataToUserData(userProto, userData)
            }
            LoginResult.Success(userData)
        } catch (e: HttpException) {
            val message = loginMapper.mapUserLoginError(e)
            LoginResult.Error(message)
        }
    }
}
