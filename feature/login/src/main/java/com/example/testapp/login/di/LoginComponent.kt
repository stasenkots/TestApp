package com.example.testapp.login.di

import com.example.network.login.api.LoginApi
import com.example.testapp.login.data.LoginRepository
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Builder

@Component
internal interface LoginComponent {
    val repository: LoginRepository

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun loginApi(loginApi: LoginApi): Builder

        fun build(): LoginComponent
    }
}
