plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "fr.valentin.plugin.command"
version = "1.7.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("com.github.ValentinJDT:ValLib:v0.1.3")
}

kotlin {
    jvmToolchain(17)
}

val globalMainClass = (group as String) + ".MainKt"

application {
    mainClass.set(globalMainClass)
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = globalMainClass
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)

    val list = mutableListOf("kotlin-stdlib-1.8.20.jar", "ValLib-v0.1.3.jar")

    from({
        configurations.runtimeClasspath.get().filter { jar ->

            println(jar.path)

            return@filter list.contains(jar.name)
        }.map { zipTree(it) }
    })
}