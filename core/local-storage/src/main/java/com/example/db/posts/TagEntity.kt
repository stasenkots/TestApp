package com.example.db.posts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tags")
data class TagEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tag_id")
    var tagId: Int = 0,
    @ColumnInfo(name = "post_id")
    var postId: Int = 0,
    @ColumnInfo(name = "tag")
    var tag: String
)
