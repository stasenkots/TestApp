package com.example

import android.app.Application
import android.content.Context
import com.example.di.ApplicationDeps
import com.example.di.DaggerApplicationComponent
import com.example.di.LocalStorageDepsStore


class TestAppApplication : Application() {

    private val appComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationDeps(ApplicationDepsImpl())
            .build()
    }

    override fun onCreate() {
        LocalStorageDepsStore.deps = appComponent
        super.onCreate()
    }


    private inner class ApplicationDepsImpl : ApplicationDeps {
        override val applicationContext: Context = this@TestAppApplication
    }

}
