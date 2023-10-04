package com.example.testapp.login.di

import androidx.datastore.core.DataStore
import com.example.network.login.api.LoginApi
import com.example.testapp.login.data.LoginRepository
import com.example.protouser.UserProto
import dagger.BindsInstance
import dagger.Component

@Component
internal interface LoginComponent {

    val repository: LoginRepository

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun loginApi(loginApi: LoginApi): Builder

        @BindsInstance
        fun userProtoStore(userProtoStore: DataStore<UserProto>): Builder

        fun build(): LoginComponent
    }
}
