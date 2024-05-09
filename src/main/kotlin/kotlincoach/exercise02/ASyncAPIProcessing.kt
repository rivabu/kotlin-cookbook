package collections.kotlincoach.exercise02

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() = runBlocking {
    val job = launch(Dispatchers.IO) {
        val users = fetchUserData("https://jsonplaceholder.typicode.com/users")
        println("${users.count()} users found")
        writeToFile(users)
    }
    job.join()
}

suspend fun fetchUserData(url: String): List<User> = withContext(Dispatchers.IO) {
    val client = HttpClient.newBuilder().build()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    parseJson(response.body())
}

fun parseJson(jsonData: String): List<User> {
    val json = org.json.JSONArray(jsonData)
    return List(json.length()) { index ->
        val obj = json.getJSONObject(index)
        User(obj.getString("name"), obj.getString("email"))
    }
}

suspend fun writeToFile(users: List<User>): Unit = withContext(Dispatchers.IO) {
    val resourceUrl = "/Users/rrientsvanburen/aaa/abol-intelllj/kotlin-cookbook/target/classes"
    File("$resourceUrl/users2.csv").bufferedWriter().use { out ->
        out.write("Username,Email\n")
        users.forEach { user ->
            out.write("${user.name},${user.email}\n")
        }
    }
}

data class User(val name: String, val email: String)
