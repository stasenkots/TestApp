package com.example.home.domain

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.db.posts.PostsDao
import com.example.home.data.Post
import com.example.home.data.PostMapper
import com.example.home.data.PostRemoteMediator
import com.example.user.data.User
import com.example.user.domain.GetUserByIdUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val remoteMediator: PostRemoteMediator,
    private val postsDao: PostsDao,
    private val postsMapper: PostMapper,
    private val getUserByIdUseCase: GetUserByIdUseCase
) {
    @OptIn(ExperimentalPagingApi::class)
    fun getAllPosts(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(
                pageSize = POSTS_NUMBERS_PER_LOAD,
                maxSize = POST_MAX_SIZE
            ),
            remoteMediator = remoteMediator
        ) {
            postsDao.postPagingSource()
        }.flow.map { pagingData ->
            pagingData.map { postEntity ->
                val user = getUserByIdUseCase.execute(postEntity.userId)
                postsMapper.map(postEntity, user)
            }
        }
    }

    companion object {
        const val POSTS_NUMBERS_PER_LOAD = 3
        const val POST_MAX_SIZE = 20

    }

}
