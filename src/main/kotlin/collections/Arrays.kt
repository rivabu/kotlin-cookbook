package collections

import kotlin.streams.toList

fun main(args: Array<String>) {
    val array1 = arrayOf(1, 2, 3, 4)
    array1.forEach { println(it) }
    val array2 = arrayOf<Long>(11, 12, 13, 14)
    println(array1[0])
    println(array1[2])
    println()
    println(array2[2])
    println(array2[3])

    val list = array1.toList()
    val list2 = list.stream().map { it * 2 }.peek { println(it) }.toList()
    val list3 = list.map { it * 2 }.onEach { println(it) }.toMutableList()
    println(list2)
    println(list3)

}