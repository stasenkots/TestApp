package com.example.codestyle

import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("io.gitlab.arturbosch.detekt")
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
    config.setFrom("$rootDir/config/detekt.yml")
}
