package com.example.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.annotations.AppContext
import com.example.protostore.userProtoStore
import com.example.user.UserProto
import dagger.Module
import dagger.Provides

@Module
internal class ProtoStoreModule {

    @Provides
    fun provideUserProtoStore(@AppContext context: Context): DataStore<UserProto> {
        return context.userProtoStore
    }


    @Provides
    @AppContext
    fun provideApplicationContext(localStorageDeps: LocalStorageDeps): Context {
        return localStorageDeps.appContext
    }
}
