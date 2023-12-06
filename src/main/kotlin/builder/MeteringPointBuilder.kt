package builder

import java.time.*

enum class CountryCode {
    NL,
    BE,
    DE
}

fun ean(ean: Long): String = (100_000_000_000_000_000 + ean).toString()

data class MeteringPointBuilder(
    var id: Long? = null,
    var ean: String? = null,
    var connectionSubType: String = "GWN",
    var number: Int? = null,
    var street: String? = null,
    var countryCode: CountryCode? = CountryCode.NL,
    var latitude: Double? = null,
    var created: Instant? = null,
    var startDate: LocalDate? = null,
    var endDate: LocalDate? = null
) {

    fun default(): MeteringPointBuilder {
        id = 1234
        ean = ean(2345678900000L)
        number = 8
        countryCode = CountryCode.NL
        street = "Pijnstorenstraat"
        latitude = 52.152457
        created = ZonedDateTime.now().minusDays(1).toInstant()
        startDate = LocalDate.now().minusMonths(3)
        endDate = startDate!!.plusMonths(12)
        return this
    }
    fun atDate(startDate: LocalDate, endDate: LocalDate = startDate.plusMonths(6)): MeteringPointBuilder {
        return copy(
            startDate = startDate,
            endDate = endDate,
            created = LocalDateTime.of(startDate, LocalTime.now()).toInstant(ZoneOffset.UTC)
        )
    }

    fun buildEntity(): MeteringPointEntity = MeteringPointEntity(
        notNull(id, "id"),
        notNull(ean, "ean"),
        created!!,
        endDate!!,
        number,
        countryCode,
        street
    )
}

private inline fun <reified T> notNull(obj: T?, name: String): T {
    return obj ?: throw IllegalArgumentException("$name can't be null")
}
