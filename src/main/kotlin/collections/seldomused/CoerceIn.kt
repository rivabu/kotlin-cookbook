package collections.collections.seldomused

fun main(args: Array<String>) {
    val range = 3..8
    println(5.coerceIn(range)) // 5
    println(1.coerceIn(range)) // 3
    println(9.coerceIn(range)) // 8

    println(5.coerceIn(2, 6)) // 5
    println(1.coerceIn(2, 6)) // 2
    println(9.coerceIn(2, 6))  //6
}

/*

this value if it's in the range, or minimumValue if this value is less
than minimumValue, or maximumValue if this value is greater than maximumValue.
 */