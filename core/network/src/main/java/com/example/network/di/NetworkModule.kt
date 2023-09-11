package com.example.network.di

import com.example.buildconfig.BuildConfigField
import com.example.network.login.api.LoginApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
internal class NetworkModule {

    @Provides
    fun provideOkhttpClient(): OkHttpClient{
        val logging = HttpLoggingInterceptor()
        val level = if (BuildConfigField.isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        logging.setLevel(level)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfigField.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun provideLoginApi(retrofit: Retrofit): LoginApi{
        return retrofit.create(LoginApi::class.java)
    }
}
