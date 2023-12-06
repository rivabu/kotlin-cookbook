package stringfunctions

import kotlin.system.measureTimeMillis

fun main() {
    val aaa = """
        als
        is 
        een 
        test
    """.trimIndent().apply {
        println(this)
    }

    var measure = measureTimeMillis {
        var a: String = ""
        (0..100_000).forEach({
            a = a + it
        }
        )
    }.also {
        println(it)
    }
}