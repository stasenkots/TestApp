package com.example.network.posts.dto

import com.google.gson.annotations.SerializedName
data class PostDto(
    @SerializedName("body")
    val body: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("reactions")
    val reactions: Int = 0,
    @SerializedName("tags")
    val tags: List<String> = listOf(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("userId")
    val userId: Int = 0
)
