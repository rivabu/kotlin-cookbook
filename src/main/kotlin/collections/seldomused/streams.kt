package collections.collections.seldomused

//https://www.baeldung.com/kotlin/java-8-stream-vs-kotlin

fun main() {
    zip()
    associateWith()
    flatMap()
}

fun flatMap() {
    val letters = listOf("This", "Is", "An", "Example")
        .flatMap { w -> w.toMutableList() } // Produces a List<Char>
        .filter { c -> Character.isUpperCase(c) }
    println(letters)


}
fun zip() {
    val numbers = listOf(1, 2, 3)
    val words = listOf("one", "two", "three")
    val result = numbers.zip(words)
    println(result) // [(1, one), (2, two), (3, three)]

}

fun associateWith() {
    val squares = listOf(1, 2, 3, 4,5).associateWith { n -> n * n }
    println(squares) // {1=1, 2=4, 3=9, 4=16, 5=25}
}