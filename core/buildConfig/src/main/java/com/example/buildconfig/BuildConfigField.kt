package com.example.buildconfig

import com.example.test.BuildConfig

object BuildConfigField {

    val baseUrl : String
        get() = BuildConfig.BASE_URL

    val isDebug: Boolean
        get() = BuildConfig.DEBUG
}
