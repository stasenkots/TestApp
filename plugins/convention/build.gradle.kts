plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

apply(from = "../../constants.gradle.kts")

group = "com.example"
version = "1.0"

gradlePlugin {
    plugins.register("convention-library") {
        id = "convention-library-plugin"
        implementationClass = "com.example.Base_library_modulePlugin"
    }
    plugins.register("convention-library-ui") {
        id = "convention-library-ui-plugin"
        implementationClass = "com.example.Ui_library_modulePlugin"
    }
    plugins.register("convention-library-feature") {
        id = "convention-library-feature-plugin"
        implementationClass = "com.example.Feature_library_modulePlugin"
    }
}


dependencies {
    compileOnly(gradleApi())
    compileOnly("com.android.library:com.android.library.gradle.plugin:7.3.1")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}
