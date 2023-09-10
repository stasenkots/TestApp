import com.google.protobuf.gradle.*

plugins {
    id("convention-library-plugin")
    id("com.google.protobuf") version "0.9.2"
}

val protobufVersion = "3.22.2"

dependencies {

    implementation(project(":core:dagger-annotations"))
    implementation("androidx.room:room-runtime:2.5.2")
    kapt("androidx.room:room-compiler:2.5.2")

    api("com.google.protobuf:protobuf-java:$protobufVersion")
    api("androidx.datastore:datastore-preferences:1.0.0")
}


protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }

    generateProtoTasks {
        all().forEach {
            it.builtins {
                create("java")
            }
        }
    }
}

