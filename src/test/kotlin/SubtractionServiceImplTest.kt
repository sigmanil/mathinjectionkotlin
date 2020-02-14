import org.junit.jupiter.api.Assertions.*

internal class SubtractionServiceImplTest {

    val minusService = SubtractionServiceImpl()

    @org.junit.jupiter.api.Test
    fun testThatNormalSubtractionWorks() {
        val minuend = 5
        val subtrahend = 2
        val expectedResult = minuend - subtrahend
        val actualResult = minusService.difference(minuend, subtrahend)

        assertEquals(expectedResult, actualResult)
    }
}