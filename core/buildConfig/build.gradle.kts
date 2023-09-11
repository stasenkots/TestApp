plugins {
    id("convention-library-plugin")
}

android {
    buildFeatures {
        buildConfig = true
    }

    buildTypes.forEach {
        it.buildConfigField("String", "BASE_URL", "\"https://dummyjson.com\"")
    }

}
