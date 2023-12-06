package junit5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTests {
    @Suppress("DIVISION_BY_ZERO")
    @Test
    fun `dividing by zero is bad`() {
        val x = 1
        val y = 0
        val exception = assertThrows<ArithmeticException> {
            x / y
        }
        assertEquals("/ by zero", exception.message)
    }
}