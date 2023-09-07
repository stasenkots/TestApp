package com.example.di

import android.content.Context
import com.example.annotations.AppContext
import kotlin.properties.Delegates

interface LocalStorageDeps {

    @AppContext
    val appContext: Context
}

interface LocalStorageDepsProvider {

    val deps: LocalStorageDeps

    companion object : LocalStorageDepsProvider by LocalStorageDepsStore
}

object LocalStorageDepsStore: LocalStorageDepsProvider {

    override var deps: LocalStorageDeps by Delegates.notNull()

}

