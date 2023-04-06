package fr.valentin.plugin.command

import fr.valentin.api.plugin.Command
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.zip.ZipFile

class TemplateCommand: Command("template", "Create an addon template for EmptyTerminal") {

    override fun execute(args: List<String>) {
        if(args.size < 2) {
            println("Use: template <plugin|command> <output>")
            return
        }

        val destination = args[1]

        when(args[0]) {
            "plugin" -> createPlugin(destination)
            "command" -> createCommand(destination)
            else -> println("Argument not found")
        }
    }

    private fun createPlugin(outputDir: String) {
        println("Creating plugin template...")
        val classLoader = this::class.java.classLoader
        classLoader.getResourceAsStream("ExamplePlugin.zip")?.use { Files.copy(it, Paths.get("$outputDir/ExamplePlugin.zip")) }

        unzipFile("$outputDir/ExamplePlugin.zip", outputDir)

        File("$outputDir/ExamplePlugin.zip").delete()

        println("Template created !")
    }

    private fun createCommand(outputDir: String) {
        println("Creating plugin template...")

        val classLoader = this::class.java.classLoader
        classLoader.getResourceAsStream("ExampleCommand.zip")?.use { Files.copy(it, Paths.get("$outputDir/ExampleCommand.zip")) }

        unzipFile("$outputDir/ExampleCommand.zip", outputDir)

        File("$outputDir/ExampleCommand.zip").delete()

        println("Template created !")
    }

    private fun unzipFile(zipFileName: String, to: String) {
        ZipFile(zipFileName).use { zip ->
            zip.entries().asSequence().forEach { entry ->
                zip.getInputStream(entry).use { input ->

                    if(entry.isDirectory) {
                        File("$to/$entry").mkdirs()
                    } else {
                        File("$to/$entry").outputStream().use { output ->
                            input.copyTo(output)
                        }
                    }
                }
            }
        }
    }

}