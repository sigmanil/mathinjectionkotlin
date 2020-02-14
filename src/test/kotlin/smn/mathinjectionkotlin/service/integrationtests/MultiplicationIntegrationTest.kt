package smn.mathinjectionkotlin.service.integrationtests
import smn.mathinjectionkotlin.ProductionRegistry
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MultiplicationIntegrationTest {

    @Test
    fun testThatNormalProductWorks() {
        val factor1 = 2
        val factor2 = 4
        val expected = factor1 * factor2

        val actual = ProductionRegistry().multiplicationService.product(factor1, factor2)
        assertEquals(expected, actual)
    }
}