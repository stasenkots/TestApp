package com.example.user.di

import com.example.network.di.NetworkComponentProvider

object UserComponentProvider {

    val userComponent: UserComponent
        get() = DaggerUserComponent.builder()
                .userApi(NetworkComponentProvider.userApi)
                .build()

}
