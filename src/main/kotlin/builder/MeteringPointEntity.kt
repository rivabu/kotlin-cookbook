package builder

import java.time.Instant
import java.time.LocalDate

data class MeteringPointEntity(
    val id: Long,
    val ean: String,
    val created: Instant,
    val endDate: LocalDate,
    val number: Int?,
    val countryCode: CountryCode?,
    val street: String?
    )