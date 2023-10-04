package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.posts.PostEntity
import com.example.db.posts.PostsDao
import com.example.db.posts.TagEntity

@Database(entities = [PostEntity::class, TagEntity::class], version = 1)
abstract class TestAppDatabase: RoomDatabase() {
    abstract fun postsDao(): PostsDao
}
