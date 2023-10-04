package com.example.network.di

import com.example.network.login.api.LoginApi
import com.example.network.posts.PostApi
import com.example.network.user.UserApi

object NetworkComponentProvider {
    private val networkComponent by lazy { DaggerNetworkComponent.create() }

    val loginApi: LoginApi
        get() = networkComponent.loginApi

    val postApi: PostApi
        get() = networkComponent.postApi

    val userApi: UserApi
        get() = networkComponent.userApi
}
