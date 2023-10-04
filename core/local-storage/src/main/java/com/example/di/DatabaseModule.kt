package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.annotations.AppContext
import com.example.db.TestAppDatabase
import com.example.db.posts.PostsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @AppContext
        applicationContext: Context
    ): TestAppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            TestAppDatabase::class.java, "testappdb"
        ).build()
    }

}
