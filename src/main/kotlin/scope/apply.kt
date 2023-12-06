package scope

data class Person(var name: String, var age: Int = 0, var city: String = "")

fun main() {
    var apply = Apply()
    apply.apply()
}

/*
The context object is available as a receiver (this). The return value is the object itself.

Use apply for code blocks that don't return a value and mainly operate on the members of the receiver object. The common
case for apply is the object configuration. Such calls can be read as “ apply the following assignments to the object.”
*/
class Apply {

    fun apply() {
        val adam = Person("Adam").apply {
            name = "Rients"
            age = 32
            city = "London"
        }
        println(adam)
    }
}

