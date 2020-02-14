import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinusServiceImplTest {

    val minusService = MinusServiceImpl()

    @Test
    fun minus() {
        val initial = 5
        val expected = -initial
        val actual = minusService.minus(initial)
        assertEquals(expected, actual)
    }
}