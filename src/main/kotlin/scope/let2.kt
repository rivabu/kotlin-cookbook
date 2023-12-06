package scope

fun main() {

    var let = Let()
    let.let()
    let.letNullableString("test")
    let.letNullableString(null) // igv null, wordt de inhoud van de let niet uitgevoerd
    let.letMoreReadable()
}

class Let {

    /*
    The context object is available as an argument (it). The return value is the lambda result.

    let can be used to invoke one or more functions on results of call chains. For example,
    the following code prints the results of two operations on a collection:
     */
    fun let() {

        // zonder let
        var numbers = mutableListOf("one", "two", "three", "four", "five")

        val resultList = numbers.map { it.length }.filter { it > 3 }
        println(resultList)

        // met let
        numbers = mutableListOf("one", "two", "three", "four", "five")
        numbers.add("sixyes")
        numbers.map { it.length }.filter { it > 3 }.let {
            println("output let: ${it.last()}")
            // and more function calls if needed
        }

        // If the code block contains a single function with it as an argument, you can use the method reference (::) instead of the lambda:
        // met let
        numbers = mutableListOf("one", "two", "three", "four", "five")
        numbers.map { it.length }.filter { it > 3 }.let(::println)


    }

    fun processNonNullString(it: String) {
        println(it)
    }

    fun letNullableString(str: String?) {

//    let is often used for executing a code block only with non-null values. To perform actions on a non-null object, use the safe call operator ?.
//    on it and call let with the actions in its lambda.
// KIJK dit is handig, je kan niks met een nullable string

        //processNonNullString(str)       // compilation error: str can be null
        val length = str?.let {
            println("let() called on $it")
            processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
            it.length
        }
    }

    fun letMoreReadable() {

        var numbers = listOf("one", "two", "three", "four")
        val modifiedFirstItem = numbers.first().let { firstItem ->
            println("The first item of the list is '$firstItem'")
            if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
        }.uppercase()
        numbers = listOf("oneone", "two", "three", "four")
        val modifiedFirstItem2 = numbers.first().let {
            println("The first item of the list is '$it'")
            if (it.length >= 5) it else "!" + it + "!"
        }.uppercase()
        println("First item after modifications: '$modifiedFirstItem'")
        println("First item after modifications: '$modifiedFirstItem2'")

    }
}



