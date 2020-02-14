package smn.mathinjectionkotlin.service

import java.lang.UnsupportedOperationException

interface ExponentiationService {
    fun exponentialProduct(base: Int, exponent: Int): Int
}

interface ExponentiationServiceComponent: MultiplicationServiceComponent {
    val exponentiationService: ExponentiationService
}

class ExponentiationServiceImpl(private val registry: ExponentiationServiceComponent):
    ExponentiationService {
    override fun exponentialProduct(base: Int, exponent: Int): Int {

        if (base < 1 || exponent < 1) {
            throw UnsupportedOperationException("Base or exponent less than 1 not supported.")
        }

        var result: Int = base
        (1 until exponent).forEach { result = registry.multiplicationService.product(result, base) }
        return result
    }
}