package com.example.home.data

import com.example.db.posts.PostEntity
import com.example.db.posts.TagEntity
import com.example.network.posts.dto.PostDto
import com.example.network.posts.dto.PostsDto
import com.example.user.data.User
import javax.inject.Inject

class PostMapper @Inject constructor() {
    fun map(postDto: PostDto): PostEntity {
        return PostEntity(
            id = postDto.id,
            body = postDto.body,
            reactions = postDto.reactions,
            title = postDto.title,
            userId = postDto.userId
        )
    }

    fun mapToTagsEntity(postsDto: PostsDto): List<TagEntity> {
        return postsDto.posts.flatMap { postDto ->
            postDto.tags.map { tag -> TagEntity(tag = tag, postId = postDto.id) }
        }
    }

    fun map(postEntity: PostEntity, user: User): Post {
        return Post(
            id = postEntity.id,
            description = postEntity.body,
            title = postEntity.title,
            username = user.username,
            image = "https://picsum.photos/seed/${postEntity.id}/300/400"
        )
    }
}
