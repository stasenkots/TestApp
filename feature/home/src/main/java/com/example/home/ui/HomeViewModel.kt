package com.example.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.di.LocalStorageComponentProvider
import com.example.home.di.DaggerHomeComponent
import com.example.home.di.HomeComponent
import com.example.home.domain.PostsRepository
import com.example.network.di.NetworkComponentProvider
import com.example.user.di.UserComponentProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    private val homeComponent: HomeComponent,
    private val postsRepository: PostsRepository = homeComponent.postsRepository
) : ViewModel() {
    val posts = postsRepository.getAllPosts()
        .flowOn(Dispatchers.IO)

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val homeComponent = DaggerHomeComponent.builder()
                .userComponent(UserComponentProvider.userComponent)
                .postApi(NetworkComponentProvider.postApi)
                .database(LocalStorageComponentProvider.database)
                .build()
            return HomeViewModel(homeComponent) as T
        }
    }
}
