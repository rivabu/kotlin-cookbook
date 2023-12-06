package collections

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    var date = LocalDateTime.parse("2020-01-01 01:01:00.01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"))
    println("$date")
}