plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.example"
version = "unspecified"

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
