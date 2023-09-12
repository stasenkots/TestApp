
apply(from = "constants.gradle.kts")

plugins {
    id("com.android.application") version ("7.3.1") apply false
    id("com.android.library") version ("7.3.1") apply false
    id("org.jetbrains.kotlin.android") version("1.6.10") apply false
    id("io.gitlab.arturbosch.detekt") version("1.22.0")
}

val reportMerge by tasks.registering(io.gitlab.arturbosch.detekt.report.ReportMergeTask::class) {
    output.set(rootProject.layout.buildDirectory.file("reports/detekt/detekt.sarif"))
}

subprojects {
    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        reports.sarif.required.set(true)
        finalizedBy(reportMerge)

    }

    reportMerge {
        input.from(tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().map { it.sarifReportFile })
    }
}

