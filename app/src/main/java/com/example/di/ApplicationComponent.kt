package com.example.di

import android.content.Context
import com.example.annotations.AppContext
import dagger.Component

@Component(dependencies = [ApplicationDeps::class])
interface ApplicationComponent: LocalStorageDeps {

    @AppContext
    override val appContext: Context

    @Component.Builder
    interface Builder {

        fun applicationDeps(applicationDeps: ApplicationDeps): Builder

        fun build(): ApplicationComponent

    }
}
