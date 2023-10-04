package com.example.home.di

import com.example.db.TestAppDatabase
import com.example.home.domain.PostsRepository
import com.example.network.posts.PostApi
import com.example.user.di.UserComponent
import com.example.user.domain.GetUserByIdUseCase
import dagger.BindsInstance
import dagger.Component


@Component(modules = [HomeModule::class], dependencies = [UserComponent::class])
interface HomeComponent {

    val postsRepository: PostsRepository
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun postApi(postApi: PostApi): Builder

        fun userComponent (userComponent: UserComponent): Builder

        @BindsInstance
        fun database(database: TestAppDatabase): Builder
        fun build(): HomeComponent
    }
}
