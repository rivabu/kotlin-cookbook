package scope

import org.springframework.http.HttpHeaders
import org.springframework.web.filter.CommonsRequestLoggingFilter

fun main() {
    val also = Also()
    also.also()
    println(also.headers())
    println(also.logFilter())
}

/*
The context object is available as an argument (it). The return value is the object itself.
also is good for performing some actions that take the context object as an argument.
Use also for actions that need a reference rather to the object than to its properties and functions,
or when you don't want to shadow this reference from an outer scope.
When you see also in the code, you can read it as “ and also do the following with the object.”
*/
class Also {
    companion object {
        private val API_KEY =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9"
    }

    fun also() {
        val numbers = mutableListOf("one", "two", "three")
        numbers
            .also { println("The list elements before adding new one: $it") }
            .add("four")
    }

    fun headers(email: String = "test@example.com") = HttpHeaders().also {
        it["X-API-Key"] = API_KEY
        it["email"] = email
    }

    fun logFilter() = CommonsRequestLoggingFilter().also {
        it.setIncludeClientInfo(true)
        it.setIncludeQueryString(true)
        it.setIncludePayload(false)
        it.setIncludeHeaders(false)
    }
}