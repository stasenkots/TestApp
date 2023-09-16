rootProject.name = "plugins"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

include(":convention")
include(":codestyle")
