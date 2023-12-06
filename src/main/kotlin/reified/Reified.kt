package reified


inline fun <reified T> myExample(name: T) {
    println("Name of your website -> " + name)
    println("Type of myClass: ${T::class.java}")
}

fun main(args: Array<String>) {

    // calling func() with String
    myExample<String>("www.tutorialspoint.com")

    // calling func() with Int value
    myExample<Int>(100)

    // calling func() with Long value
    myExample<Long>(1L)

}
