package com.example.di

import androidx.datastore.core.DataStore
import com.example.db.TestAppDatabase
import com.example.protouser.UserProto
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ProtoStoreModule::class, DatabaseModule::class], dependencies = [LocalStorageDeps::class])
interface LocalStorageComponent {

    val userProtoStore: DataStore<UserProto>

    val database: TestAppDatabase

    @Component.Builder
    interface Builder {

        fun deps(deps: LocalStorageDeps): Builder

        fun build(): LocalStorageComponent
    }
}


