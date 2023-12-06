package scope

fun main() {
    Run().getNullableLength(null)
    Run().getNullableLength("")
    Run().getNullableLength("some string with Kotlin")

    Run().runAndLet()
}

class MultiportService(var url: String, var port: Int) {
    fun query(value: String) {
        url = url + ":" + value
        //println(url)
    }
    fun prepareRequest(): String {
        return "https://"
    }
    override
    fun toString():String {
        return "\nurl: $url \nport: $port"
    }
}

class Run {
    /*
    The context object is available as a receiver (this). The return value is the lambda result.
    run does the same as with but invokes as let- as an extension function of the context object.
    run is useful when your lambda contains both the object initialization and the computation of the return value.
 */

    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {                                                  // 1
            println("\tis empty? " + this.isEmpty())                    // 2
            println("\tlength = $length")
            this.length                                                 // 3
        }
    }
    fun runAndLet() {

        // letop, de instance variabelen van MultiportService wordt aangepast en functies worden aangeroepen
        val service = MultiportService("https://example.kotlinlang.org", 80)
        val result = service.run {
            port = 8080
            query(prepareRequest() + " to port $port")
        }
        println(result) // print kotlin:Unit

        // the same code written with let() function:
        val letResult = service.let {
            it.port = 8080
            it.query(it.prepareRequest() + " to port ${it.port}")
        }
        println(letResult)
        service.also { println(it) }
        println(service)
    }
}
