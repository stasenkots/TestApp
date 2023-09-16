plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

apply(from = "../../constants.gradle.kts")

group = "com.example"
version = "1.0"

gradlePlugin {
    plugins.register("detekt-plugin") {
        id = "detekt-plugin"
        implementationClass = "com.example.codestyle.Detekt_configurationPlugin"
    }
}

dependencies {
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.1")
}
