package com.example

import com.android.build.gradle.LibraryExtension

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("detekt-plugin")
}



configure<LibraryExtension> {
    val compileSdkVersion: Int by rootProject.extra
    val targetSdkVersion: Int by rootProject.extra
    val minSdkVersion: Int by rootProject.extra
    val appPackage: String by rootProject.extra

    namespace = appPackage
    compileSdk = compileSdkVersion

    defaultConfig {
        minSdk = minSdkVersion
        targetSdk = targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        buildConfig = false
    }
}


dependencies {
    add( "implementation", "com.google.dagger:dagger:${rootProject.extra["daggerVersion"]}")
    add("kapt",  "com.google.dagger:dagger-compiler:${rootProject.extra["daggerVersion"]}")
    add("implementation",  "androidx.core:core-ktx:${rootProject.extra["androidxCoreVersion"]}")
}
