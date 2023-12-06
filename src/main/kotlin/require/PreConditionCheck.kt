package require

class PreConditionCheck(var list: List<String>) {
    init {
        require(list.size > 2, { "list should be longer than 2" })
        requireNotNull(list)
        check(list.size > 2, { "list should be longer than 2" })
        checkNotNull(list)
    }

    fun calculate(): String {
        return list.toString()
    }
}

fun main() {
    try {
        val list = listOf<String>("A")
        var value = PreConditionCheck(list).calculate()
        println(value)
    } catch (e: Exception) {

    }
}