package scope

fun main() {
    With().with()
}

class With {
    /*
    A non-extension function: the context object is passed as an argument, but inside the lambda, it's available as a receiver (this).
    The return value is the lambda result.
    We recommend with for calling functions on the context object without providing the lambda result.
    In the code, with can be read as “ with this object, do the following.”
 */
    fun with() {
        val numbers = mutableListOf("one", "two", "three")
        with(numbers) {
            println("'with' is called with argument $this")
            println("It contains $size elements")
        }

        // Another use case for with is introducing a helper object whose properties or functions will be used for
        // calculating a value.
        // let op, het result van de lambda (hier een string) wordt teruggegeven
        val firstAndLast = with(numbers) {
            "The first element is ${first()}," +
                    " the last element is ${last()}"
        }
        println(firstAndLast)
    }
}
