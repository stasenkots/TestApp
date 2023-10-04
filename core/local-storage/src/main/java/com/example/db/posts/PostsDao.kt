package com.example.db.posts

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: List<PostEntity>)

    @Insert
    fun insertTags(tags: List<TagEntity>)

    @Query("SELECT * FROM posts")
    fun postPagingSource(): PagingSource<Int, PostEntity>
}
