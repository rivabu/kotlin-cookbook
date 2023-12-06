package collections

fun main() {
    val list = 0..10
    val pieces = list.chunked(3)
    pieces.forEach { println(it)}
//    println(pieces)


}
/*
[[0, 1, 2], [3, 4, 5], [6, 7, 8], [9, 10]]
Sums: [3, 12, 21, 19]
[[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9], [8, 9, 10]]
Averages: [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
[[0, 1, 2], [3, 4, 5], [6, 7, 8]]
Averages: [1.0, 4.0, 7.0]
 */