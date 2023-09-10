package com.example

import com.android.build.gradle.LibraryExtension

plugins {
    id("convention-library-plugin")
}

configure<LibraryExtension> {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["composeUiVersion"].toString()
    }
}

dependencies {
    add("implementation", "androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.extra["lifecycleVersion"]}")
    add( "implementation", "androidx.compose.ui:ui:${rootProject.extra["composeUiVersion"]}")
    add( "implementation", "androidx.compose.ui:ui-tooling-preview:${rootProject.extra["composeUiVersion"]}")
    add( "implementation", "androidx.compose.material3:material3:${rootProject.extra["materialVersion"]}")
    add( "debugImplementation", "androidx.compose.ui:ui-tooling:${rootProject.extra["composeUiVersion"]}")
    add("debugImplementation", "androidx.compose.ui:ui-test-manifest:${rootProject.extra["composeUiVersion"]}")

}
