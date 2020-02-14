package smn.mathinjectionkotlin.service

import io.mockk.every
import io.mockk.slot
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import smn.mathinjectionkotlin.DefaultTestRegistry

internal class DivisionServiceImplTest {

    val testRegistry = object : DefaultTestRegistry() {
        override val divisionService = DivisionServiceImpl(this)
    }

    @Test
    fun quotientAndRemainder() {
        val dividend = 10
        val divisor = 3
        val expectedQuotient = dividend / divisor
        val expectedRemainder = dividend % divisor

        val plusSlot1 = slot<Int>()
        val plusSlot2 = slot<Int>()
        every { testRegistry.additionService.sum(capture(plusSlot1), capture(plusSlot2)) } answers { plusSlot1.captured + plusSlot2.captured }
        val minusSlot1 = slot<Int>()
        val minusSlot2 = slot<Int>()
        every { testRegistry.subtractionService.difference(capture(minusSlot1), capture(minusSlot2)) } answers { minusSlot1.captured - minusSlot2.captured}

        val (actualQuotient, actualRemainder) = testRegistry.divisionService.quotientAndRemainder(dividend, divisor)

        assertEquals(expectedQuotient, actualQuotient)
        assertEquals(expectedRemainder, actualRemainder)

    }
}