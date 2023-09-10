plugins {
    id("convention-library-plugin")
    id("com.google.protobuf") version "0.9.2"
}


dependencies {

    implementation(project(":core:dagger-annotations"))
    implementation("androidx.room:room-runtime:${rootProject.extra["roomVersion"]}")
    kapt("androidx.room:room-compiler:${rootProject.extra["roomVersion"]}")

    api("com.google.protobuf:protobuf-java:${rootProject.extra["protobufVersion"]}")
    api("androidx.datastore:datastore-preferences:${rootProject.extra["dataStoreVersion"]}")
}


protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${rootProject.extra["protobufVersion"]}"
    }

    generateProtoTasks {
        all().forEach {
            it.builtins {
                create("java")
            }
        }
    }
}

