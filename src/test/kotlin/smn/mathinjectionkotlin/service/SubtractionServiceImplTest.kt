package smn.mathinjectionkotlin.service

import smn.mathinjectionkotlin.DefaultTestRegistry
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*

internal class SubtractionServiceImplTest {

    val testRegistry = object : DefaultTestRegistry() {
        override val subtractionService =
            SubtractionServiceImpl(this)
    }

    @org.junit.jupiter.api.Test
    fun testThatNormalSubtractionWorks() {
        val minuend = 5
        val subtrahend = 2
        val expectedResult = minuend - subtrahend
        val actualResult = testRegistry.subtractionService.difference(minuend, subtrahend)

        assertEquals(expectedResult, actualResult)
    }

    @org.junit.jupiter.api.Test
    fun testThatSubtractionWithNegativeResultWorks() {
        val minuend = 2
        val subtrahend = 5
        val expectedResult = minuend - subtrahend

        every { testRegistry.minusService.minus(3) } returns -3

        val actualResult = testRegistry.subtractionService.difference(minuend, subtrahend)

        assertEquals(expectedResult, actualResult)
        verify(exactly = 1) {
            testRegistry.minusService.minus(3)
        }
    }

    @org.junit.jupiter.api.Test
    fun testThatSubtractionWithNegativeMinuendWorks() {
        val minuend = -2
        val subtrahend = 5
        val expectedResult = minuend - subtrahend

        every { testRegistry.minusService.minus(7) } returns -7

        val actualResult = testRegistry.subtractionService.difference(minuend, subtrahend)

        assertEquals(expectedResult, actualResult)

        verify(exactly = 1) {
            testRegistry.minusService.minus(7)
        }
    }

    @org.junit.jupiter.api.Test
    fun testThatSubtractionWithNegativeSubtrahendWorks() {
        val minuend = 2
        val subtrahend = -5
        val expectedResult = minuend - subtrahend

        val actualResult = testRegistry.subtractionService.difference(minuend, subtrahend)

        assertEquals(expectedResult, actualResult)

    }
}