package com.example.home.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.db.TestAppDatabase
import com.example.db.posts.PostEntity
import com.example.db.posts.PostsDao
import com.example.db.posts.TagEntity
import com.example.network.posts.PostApi
import com.example.network.posts.dto.PostDto
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PostRemoteMediator @Inject constructor(
    private val postsDao: PostsDao,
    private val postApi: PostApi,
    private val postMapper: PostMapper
) : RemoteMediator<Int, PostEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PostEntity>
    ): MediatorResult {

        if (loadType == LoadType.PREPEND) {
            return MediatorResult.Success(endOfPaginationReached = true)
        }

        return try {
            val postsDto = postApi.getPosts(state.config.initialLoadSize, state.anchorPosition ?: 0)
            val postsEntity = postsDto.posts.map { postMapper.map(it) }
            val tagsEntity = postMapper.mapToTagsEntity(postsDto)

            postsDao.insertPosts(postsEntity)
            postsDao.insertTags(tagsEntity)
            MediatorResult.Success(
                endOfPaginationReached = postsDto.totalPostsNumber == state.anchorPosition
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}
