plugins {
    id("convention-library-plugin")
    id("com.google.protobuf") version "0.9.1"
}


dependencies {
    api("com.google.protobuf:protobuf-java:${rootProject.extra["protobufVersion"]}")
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
