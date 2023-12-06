package extension

import org.apache.commons.lang3.StringUtils


fun String.substringBetweenInclude( open: String, close: String): String =
    open + StringUtils.substringBetween(this, open, close ) + close;


fun main() {
    println("rients".substringBetweenInclude( "i", "t"))
}