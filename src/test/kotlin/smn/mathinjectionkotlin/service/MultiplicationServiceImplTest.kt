package smn.mathinjectionkotlin.service

import smn.mathinjectionkotlin.ComponentRegistry
import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MultiplicationServiceImplTest {

    val testRegistry = object : ComponentRegistry {
        override val subtractionService = mockk<SubtractionService>()
        override val additionService = mockk<AdditionService>()
        override val multiplicationService =
            MultiplicationServiceImpl(this)
        override val divisionService = mockk<DivisionService>()
        override val exponentiationService = mockk<ExponentiationService>()
        override val minusService = mockk<MinusService>()
    }

    @Test
    fun testThatNormalProductWorks() {
        val factor1 = 2
        val factor2 = 4
        val expected = factor1 * factor2

        val slot1 = slot<Int>()
        val slot2 = slot<Int>()
        every {
            testRegistry.additionService.sum(capture(slot1), capture(slot2))
        } answers {
            slot1.captured + slot2.captured
        }

        val actual = testRegistry.multiplicationService.product(factor1, factor2)
        assertEquals(expected, actual)

        verify {
            testRegistry.additionService.sum(any(), any())
        }
    }

    @Test
    fun testThatNegativeProductWorks() {
        val factor1 = -2
        val factor2 = 4
        val expected = factor1 * factor2

        val slot1 = slot<Int>()
        val slot2 = slot<Int>()
        every {
            testRegistry.additionService.sum(capture(slot1), capture(slot2))
        } answers {
            slot1.captured + slot2.captured
        }
        val minusSlot = slot<Int>()
        every { testRegistry.minusService.minus(capture(minusSlot)) } answers { -minusSlot.captured }

        val actual = testRegistry.multiplicationService.product(factor1, factor2)
        assertEquals(expected, actual)

        verify {
            testRegistry.additionService.sum(any(), any())
            testRegistry.minusService.minus(any())
        }
    }
}