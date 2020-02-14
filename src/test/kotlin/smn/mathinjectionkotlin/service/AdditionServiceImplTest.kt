package smn.mathinjectionkotlin.service
import smn.mathinjectionkotlin.DefaultTestRegistry
import org.junit.jupiter.api.Test
import io.mockk.every
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*

internal class AdditionServiceImplTest {

    val testRegistry = object : DefaultTestRegistry() {
        override val additionService = AdditionServiceImpl(this)
    }

    @Test
    fun testThatNormalSumWorks() {
        val term1 = 2
        val term2 = 4
        val expected = term1 + term2

        every { testRegistry.subtractionService.difference(2, -4) } returns expected
        val minusSlot = slot<Int>()
        every { testRegistry.minusService.minus(capture(minusSlot)) } answers { -minusSlot.captured }

        val actual = testRegistry.additionService.sum(term1, term2)
        assertEquals(expected, actual)

        verify(exactly = 1) {
            testRegistry.subtractionService.difference(2, -4)
            testRegistry.subtractionService.difference(any(), any())
            testRegistry.minusService.minus(any())
        }
    }
}