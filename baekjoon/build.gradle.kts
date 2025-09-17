import org.gradle.api.GradleException
import org.gradle.api.tasks.JavaExec

plugins {
    kotlin("jvm") version "2.0.21"
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

application {
    mainClass.set("baekjoon.runner.RunnerKt")
}

val runProblem by tasks.registering(JavaExec::class) {
    group = "application"
    description = "Run a specific Baekjoon solution with -PproblemId=xxxx"
    val problemIdProvider = project.providers.gradleProperty("problemId")
    mainClass.set("baekjoon.runner.RunnerKt")
    classpath = sourceSets["main"].runtimeClasspath
    doFirst {
        if (!problemIdProvider.isPresent) {
            throw GradleException("Please provide -PproblemId=1234")
        }
        args = listOf(problemIdProvider.get())
    }
}

tasks.withType(JavaExec::class).configureEach {
    standardInput = System.`in`
}
