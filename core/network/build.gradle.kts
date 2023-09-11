plugins {
    id("convention-library-plugin")
}

dependencies {
    implementation(project(":core:buildConfig"))

    implementation("com.squareup.okhttp3:logging-interceptor:${rootProject.extra["okhttpLoggingInterceptorVersion"]}")
    api("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofitVersion"]}")
    implementation("com.squareup.retrofit2:converter-gson:${rootProject.extra["retrofitVersion"]}")
}
