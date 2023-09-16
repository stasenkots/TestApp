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
    implementation("com.example:codestyle:1.0")
    implementation("com.android.library:com.android.library.gradle.plugin:${project.extra["androidPluginVersion"]}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${project.extra["kotlinVersion"]}")
}
