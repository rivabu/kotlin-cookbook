package collections.kotlincoach.exercise01

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    // Load the file from classpath
    val resourceUrl = Thread.currentThread().contextClassLoader.getResource("users.csv")
    val usersFile = Paths.get(resourceUrl.toURI())
    val users = Files.readAllLines(usersFile).drop(1).map {
        it.split(",").let { (name, email) -> User(name, email) }
    }

    val duplicates = users.groupBy { it.email }
        .filter { it.value.size > 1 }
        .flatMap { it.value }
        .sortedBy { it.email }

    File("${usersFile.parent}/duplicates.csv").bufferedWriter().use { out ->
        out.write("Name,Email\n")
        duplicates.forEach { out.write("${it.name},${it.email}\n") }
    }

    println("Duplicates have been written to duplicates.csv")
}

data class User(val name: String, val email: String)
