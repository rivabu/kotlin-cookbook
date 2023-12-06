package ean13


private fun String.isEan13(): Boolean {
    if (this.length != 13) return false
    if (this.any { !it.isDigit() }) return false

    val checkDigit = this.last().digitToInt()
    val total = this.dropLast(1).foldIndexed(0) { index, acc, c ->
        val checkValue = if (index % 2 == 1) (c.digitToInt() * 3) else c.digitToInt()
        acc + checkValue
    }
    return checkDigit == (10 - total % 10) % 10
}


fun main() {
    var match = "1234567890123".isEan13()
    println("1234567890123: $match")

    match = "8705619347905".isEan13()
    println("8705619347905: $match")

}