package com.example.user.di

import com.example.network.user.UserApi
import com.example.user.domain.GetUserByIdUseCase
import dagger.BindsInstance
import dagger.Component

@Component(modules = [UserModule::class])
interface UserComponent {
    val getUserByIdUseCase: GetUserByIdUseCase

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun userApi(userApi: UserApi): Builder

        fun build(): UserComponent
    }
}
