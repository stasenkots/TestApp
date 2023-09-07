package com.example.network.di

import com.example.network.login.api.LoginApi

object NetworkComponentProvider {
    private val networkComponent by lazy { DaggerNetworkComponent.create() }

    val loginApi: LoginApi
        get() = networkComponent.loginApi
}
