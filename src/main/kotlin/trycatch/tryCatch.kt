package trycatch

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun main() {
    val date = try {
        LocalDate.parse("01-01-2000Q", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    } catch (ex: DateTimeParseException) {
        ex.printStackTrace()
    }
    println(date)
}