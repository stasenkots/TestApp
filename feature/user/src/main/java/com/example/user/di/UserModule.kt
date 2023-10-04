package com.example.user.di

import com.example.user.domain.GetUserByIdUseCase
import com.example.user.domain.GetUserByUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface UserModule {

    @Binds
    fun getUserByIdUseCase(getUserByUseCaseImpl: GetUserByUseCaseImpl): GetUserByIdUseCase
}
