plugins {
    kotlin("jvm") version "1.8.20"
}

group = "fr.valentin.plugin.command"
version = "1.6"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("dependencies/ValLib-0.1.0.jar"))
}

kotlin {
    jvmToolchain(17)
}
