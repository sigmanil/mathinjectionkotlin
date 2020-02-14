package smn.mathinjectionkotlin.service

import io.mockk.every
import io.mockk.slot
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import smn.mathinjectionkotlin.DefaultTestRegistry

internal class ExponentiationServiceImplTest {

    val testRegistry = object : DefaultTestRegistry() {
        override val exponentiationService = ExponentiationServiceImpl(this)
    }

    @Test
    fun exponentialProduct() {
        val base = 2
        val exponent = 3
        val expectedExponentialProduct = Math.pow(base.toDouble(), exponent.toDouble()).toInt()

        val slot1 = slot<Int>()
        val slot2 = slot<Int>()
        every { testRegistry.multiplicationService.product(capture(slot1), capture(slot2)) } answers { slot1.captured * slot2.captured }

        val actualExponentialProduct = testRegistry.exponentiationService.exponentialProduct(base, exponent)

        assertEquals(expectedExponentialProduct, actualExponentialProduct)
    }
}