package oop

class Task1(val name: String) {
    var priority = 3
        set(value) {
            field = value.coerceIn(1..5)
        }

    val lowPriority
        get() = priority < 3
}

fun main() {
    var task1 = Task1("eten")
    println("lowPriority: ${task1.lowPriority}")
    task1.priority = 2
    println("lowPriority: ${task1.lowPriority}")

}