package com.example.home.di

import androidx.room.RoomDatabase
import com.example.db.TestAppDatabase
import com.example.db.posts.PostsDao
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun providePostDao(database: TestAppDatabase): PostsDao {
        return database.postsDao()
    }
}
