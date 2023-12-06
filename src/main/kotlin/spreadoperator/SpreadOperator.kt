package collections.spreadoperator


fun main() {
    val numbers = intArrayOf(1, 2, 3, 4)
    val summation = sum(*numbers)
    val equals = 10 == summation
    println("summation: $summation")
}

fun sum(vararg xs: Int): Int = xs.sum()
