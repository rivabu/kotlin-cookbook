package collections

import collections.collections.seldomused.rangeTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.contains
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDate

class RangeTests {
    @Test
    internal fun `coerceIn given a range`() {
        val range = 3..8

        assertThat(5, `is`(5.coerceIn(range)))
        assertThat(range.first, `is`(1.coerceIn(range)))
        assertThat(range.last, `is`(9.coerceIn(range)))
    }

    @Test
    internal fun `coerceIn given min and max`() {
        val min = 2
        val max = 6

        assertThat(5, `is`(5.coerceIn(min, max)))
        assertThat(min, `is`(1.coerceIn(min, max)))
        assertThat(max, `is`(9.coerceIn(min, max)))
    }

    @Test
    internal fun chunked() {
        val range = 0..10

        val chunked = range.chunked(3)
        assertThat(
            chunked, contains(
                listOf(0, 1, 2), listOf(3, 4, 5),
                listOf(6, 7, 8), listOf(9, 10)
            )
        )

        assertThat(range.chunked(3) { it.sum() }, `is`(listOf(3, 12, 21, 19)))
        assertThat(range.chunked(3) { it.average() }, `is`(listOf(1.0, 4.0, 7.0, 9.5)))
    }

    @Test
    internal fun windowed() {
        val range = 0..10

        assertAll("size = 3, step = 1",
            {
                assertThat(range.windowed(3, 1),
                    contains(
                        listOf(0, 1, 2), listOf(1, 2, 3), listOf(2, 3, 4),
                        listOf(3, 4, 5), listOf(4, 5, 6), listOf(5, 6, 7),
                        listOf(6, 7, 8), listOf(7, 8, 9), listOf(8, 9, 10)))
            },
            {
                assertThat(range.windowed(3, 1) { it.average() },
                    contains(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0))
            }
        )

        assertAll("size = 3, step = 3",
            {
                assertThat(range.windowed(3, 3),
                    contains(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8)))
            },
            {
                assertThat(
                    range.windowed(3, 3) { it.average() },
                    contains(1.0, 4.0, 7.0))
            })
    }

    @Test
    internal fun `LocalDate in a range`() {
        val startDate = LocalDate.now()
        val midDate = startDate.plusDays(3)
        val endDate = startDate.plusDays(5)

        val dateRange = startDate..endDate

        assertAll(
            { assertTrue(startDate in dateRange) },
            { assertTrue(midDate in dateRange) },
            { assertTrue(endDate in dateRange) },
            { assertTrue(startDate.minusDays(1) !in dateRange) },
            { assertTrue(endDate.plusDays(1) !in dateRange) }
        )
    }

    @Test
    internal fun `use LocalDate as a progression`() {
        val startDate = LocalDate.now()
        val endDate = startDate.plusDays(5)

        val dateRange = startDate..endDate

        dateRange.forEachIndexed { index, localDate ->
            assertEquals(localDate, startDate.plusDays(index.toLong()))
        }

        val dateList = dateRange.map { it.toString() }
        assertEquals(6, dateList.size)
    }

    @Test
    internal fun `use LocalDate as a progression with a step`() {
        val startDate = LocalDate.now()
        val endDate = startDate.plusDays(5)

        val dateRange = startDate..endDate step 2
        dateRange.forEachIndexed { index, localDate ->
            assertEquals(localDate, startDate.plusDays(index.toLong() * 2))
        }

        val dateList = dateRange.map { it.toString() }
        assertEquals(3, dateList.size)
    }

}