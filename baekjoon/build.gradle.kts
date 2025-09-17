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
    // 실행할 메인 클래스 지정 (문제마다 바꿔주면 됨)
    mainClass.set("")
}
