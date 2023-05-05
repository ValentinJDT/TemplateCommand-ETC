plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "fr.valentin.plugin.command"
version = "1.5"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(files("dependencies/ValLib-0.1.0.jar"))
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