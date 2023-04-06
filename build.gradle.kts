plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "fr.valentin.plugin.command"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(files("dependencies/API-1.0-SNAPSHOT.jar"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}