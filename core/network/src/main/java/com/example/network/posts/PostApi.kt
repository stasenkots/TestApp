package com.example.network.posts

import com.example.network.posts.dto.PostsDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET("posts")
    suspend fun getPosts(
        @Query("limit")
        limit: Int,
        @Query("skip")
        skip: Int,
    ): PostsDto
}
