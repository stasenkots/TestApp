package com.example

import com.android.build.gradle.LibraryExtension

plugins {
    id("convention-library-ui-plugin")
}

dependencies {
    add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.extra["coroutinesVersion"]}")
    add("implementation", "androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.extra["lifecycleVersion"]}")
    add("implementation", "androidx.lifecycle:lifecycle-viewmodel-compose:${rootProject.extra["lifecycleVersion"]}")
}
