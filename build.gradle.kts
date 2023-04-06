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
    implementation(files("C:\\Users\\v.jeandot\\IdeaProjects\\PluginAPI\\API\\build\\libs\\API-1.0-SNAPSHOT.jar", "C:\\Users\\v.jeandot\\IdeaProjects\\PluginAPI\\EmptyTerminal\\build\\libs\\EmptyTerminal-1.0-SNAPSHOT.jar"))
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