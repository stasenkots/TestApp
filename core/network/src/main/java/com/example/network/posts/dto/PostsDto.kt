package com.example.network.posts.dto


import com.google.gson.annotations.SerializedName

data class PostsDto(
    @SerializedName("posts")
    val posts: List<PostDto> = listOf(),
    @SerializedName("total")
    val totalPostsNumber: Int
)


