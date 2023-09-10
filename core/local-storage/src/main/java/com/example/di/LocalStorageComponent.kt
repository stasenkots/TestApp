package com.example.di

import androidx.datastore.core.DataStore
import com.example.user.UserProto
import dagger.Component

@Component(modules = [ProtoStoreModule::class], dependencies = [LocalStorageDeps::class])
interface LocalStorageComponent {

    val userProtoStore: DataStore<UserProto>

    @Component.Builder
    interface Builder {

        fun deps(deps: LocalStorageDeps): Builder

        fun build(): LocalStorageComponent
    }
}


