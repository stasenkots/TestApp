plugins {
    id("convention-library-feature-plugin")
}

android {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

dependencies {
    implementation(project(":core:ui-components"))
    implementation(project(":core:network"))
    api(project(":core:local-storage"))
    api(project(":core:dagger-annotations"))
}
