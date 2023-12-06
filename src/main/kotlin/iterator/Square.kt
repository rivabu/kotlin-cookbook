package collections.iterator

/**
 * Массив, для которого вызывается функция расширения:

[1, 4, 9, 16, 25]
Новые значения этого массива:

[1, 16, 81, 256, 625]

В задании было сказано "для работы с изменяемой коллекцией", на вход подавался массив.
Сделала две реализации для коллекций и для массива
 */

private fun Iterable<Int>.square(): Iterable<Int> {
    return this.map {
        it * it
    }
}

private fun Array<Int>.square(): Array<Int> {
    return Array(size) { this[it] * this[it] }
}

fun main() {
    val args = mutableListOf(1, 4, 9, 16, 25)
    println(args.square())

    val arrayArgs = arrayOf(1, 4, 9, 16, 25)
    println(arrayArgs.square().joinToString(", "))
}

