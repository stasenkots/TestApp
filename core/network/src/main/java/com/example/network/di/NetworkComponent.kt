package com.example.network.di

import com.example.network.login.api.LoginApi
import dagger.Component

@Component(modules = [NetworkModule::class])
internal interface NetworkComponent {
    val loginApi: LoginApi
}
