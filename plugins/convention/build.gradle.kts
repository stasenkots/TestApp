plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "com.example"
version = "1.0"

gradlePlugin {
    plugins.register("convention-library") {
        id = "convention-library-plugin"
        implementationClass = "com.example.base.Base_library_modulePlugin"
    }
}


dependencies {
    compileOnly(gradleApi())
    compileOnly("com.android.library:com.android.library.gradle.plugin:7.3.1")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    compileOnly("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:1.7.20")
}
