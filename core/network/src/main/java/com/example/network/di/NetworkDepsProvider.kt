package com.example.network.di

object NetworkDepsProvider {
    private val networkComponent = DaggerNetworkComponent.create()

    val loginApi = networkComponent.loginApi

}
