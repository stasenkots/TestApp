package com.example.di

import android.content.Context
import com.example.annotations.AppContext
import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    @Provides
    @AppContext
    fun applicationContext(applicationDeps: ApplicationDeps): Context {
        return applicationDeps.applicationContext
    }
}
