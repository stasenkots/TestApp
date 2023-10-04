package com.example.di

import androidx.datastore.core.DataStore
import com.example.db.TestAppDatabase
import com.example.protouser.UserProto

object LocalStorageComponentProvider {
    private val localStorageComponent by lazy {
        DaggerLocalStorageComponent
            .builder()
            .deps(LocalStorageDepsProvider.deps)
            .build()
    }

    val userProtoStore: DataStore<UserProto>
        get() = localStorageComponent.userProtoStore

    val database: TestAppDatabase
        get() = localStorageComponent.database
}
