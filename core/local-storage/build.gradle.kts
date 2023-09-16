
plugins {
    id("convention-library-plugin")
}

android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
            }
        }
    }

}


dependencies {

    implementation(project(":core:dagger-annotations"))
    api(project(":core:local-storage:proto"))
    implementation("androidx.room:room-runtime:${rootProject.extra["roomVersion"]}")
    implementation("androidx.room:room-paging:${rootProject.extra["roomVersion"]}")
    kapt("androidx.room:room-compiler:${rootProject.extra["roomVersion"]}")
    implementation("androidx.paging:paging-common:${rootProject.extra["pagingVersion"]}")

    api("androidx.datastore:datastore-preferences:${rootProject.extra["dataStoreVersion"]}")
}
