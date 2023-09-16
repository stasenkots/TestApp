package com.example.codestyle

import io.gitlab.arturbosch.detekt.extensions.DetektExtension

plugins {
    id("io.gitlab.arturbosch.detekt")
}
configure<DetektExtension> {
    config.setFrom("$rootDir/config/detekt.yml")
}
