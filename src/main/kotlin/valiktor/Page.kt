package valiktor

import org.valiktor.ConstraintViolationException
import org.valiktor.functions.isLessThanOrEqualTo
import org.valiktor.functions.isPositive
import org.valiktor.functions.isPositiveOrZero
import org.valiktor.i18n.mapToMessage
import org.valiktor.validate
import java.time.LocalDate
import java.util.*

data class Page(val offset: Long, val limit: Int) {
    init {
        validate(this) {
            validate(Page::offset).isPositiveOrZero()
            validate(Page::limit).isPositive().isLessThanOrEqualTo(1000)

        }
    }
}

fun main() {

    create(-1, -1)
    create(0, 0)
    create(1, 1)
    create(1, 1001)
}

fun create(offset: Long, limit: Int) {
    try {
        Page(offset, limit)
    } catch (ex: ConstraintViolationException) {
        val violations = ex.constraintViolations
            .mapToMessage(baseName = "messages", locale = Locale.GERMANY)
            .joinToString("\n") { " - ${it.property}: ${it.message}" }
        println("--- $violations")
    }
}