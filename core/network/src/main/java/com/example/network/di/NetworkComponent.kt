package com.example.network.di

import com.example.network.login.api.LoginApi
import com.example.network.posts.PostApi
import com.example.network.user.UserApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
internal interface NetworkComponent {
    val loginApi: LoginApi
    val postApi: PostApi
    val userApi: UserApi
}
