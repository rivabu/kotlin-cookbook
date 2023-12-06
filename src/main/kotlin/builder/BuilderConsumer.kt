package builder

import java.time.LocalDate

fun meteringPoint(): MeteringPointBuilder = MeteringPointBuilder()

class BuilderConsumer {

    var data = mutableListOf<MeteringPointEntity>()

    private fun insert(adjust: (MeteringPointBuilder) -> Unit) = meteringPoint()
        .default() // vul met default values
        .also(adjust) // overschrijf met input
        .let {
            save(it) // store de default
        }

    private fun save(builder: MeteringPointBuilder = meteringPoint().default()) {
        val toInsert = builder.buildEntity()
        data.add(toInsert)
    }

    fun fill() {
        insert { it.number = 123456 }
        insert {
            it.number = 1234567
            it.street = "StreetB"
        }
        val inserted = listOf(6L, 24L, 12L)
            .map { LocalDate.now().minusMonths(it) } // maakt van de Longs nu LocalDate's
            .map { meteringPoint().default().atDate(it) } // maarkt er nu meteringpoints van
            .map { save(it) } // en sla ze op

        save() // save the default

        val builder = meteringPoint().default().also { it.street = "StreetA" }
        println(builder)

    }

    fun printAll() {
        data.forEach { elem -> println(elem) }
    }


}

fun main() {
    val testRun = BuilderConsumer()
    testRun.fill()
    testRun.printAll()
}