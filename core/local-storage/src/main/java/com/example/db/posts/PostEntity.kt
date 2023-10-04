package com.example.db.posts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey
    var id: Int = 0,
    @ColumnInfo(name = "body")
    var body: String = "",
    @ColumnInfo(name = "reactions")
    var reactions: Int = 0,
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "user_id")
    var userId: Int = 0
)
