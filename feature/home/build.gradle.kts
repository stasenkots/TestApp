plugins {
    id("convention-library-feature-plugin")
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:local-storage"))
    implementation(project(":feature:user"))

    implementation("androidx.paging:paging-runtime:${rootProject.extra["pagingVersion"]}")
    implementation("androidx.paging:paging-compose:${rootProject.extra["pagingVersion"]}")

    implementation("io.coil-kt:coil-compose:${rootProject.extra["coilVersion"]}")

    implementation("androidx.room:room-runtime:${rootProject.extra["roomVersion"]}")
    implementation(project(":core:ui-components"))
}
