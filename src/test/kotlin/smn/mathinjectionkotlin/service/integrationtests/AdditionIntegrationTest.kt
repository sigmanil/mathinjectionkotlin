package smn.mathinjectionkotlin.service.integrationtests
import smn.mathinjectionkotlin.ProductionRegistry
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class AdditionIntegrationTest {

    @Test
    fun testThatNormalSumWorks() {
        val term1 = 2
        val term2 = 4
        val expected = term1 + term2

        val actual = ProductionRegistry().additionService.sum(term1, term2)
        assertEquals(expected, actual)
    }
}