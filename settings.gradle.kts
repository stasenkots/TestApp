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
rootProject.name = "TestApp"

include(":app")

include(":feature:login")
include(":core:ui-components")
include(":core:network")
include(":core:local-storage")
include(":core:dagger-annotations")
include(":convention")
include(":core:buildConfig")

includeBuild("plugins")
