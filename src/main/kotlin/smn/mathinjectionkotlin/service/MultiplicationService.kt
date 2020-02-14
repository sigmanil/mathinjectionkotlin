package smn.mathinjectionkotlin.service

interface MultiplicationService {
    fun product(factor1: Int, factor2: Int): Int
}

interface MultiplicationServiceComponent: AdditionServiceComponent,
    MinusServiceComponent {
    val multiplicationService: MultiplicationService
}

class MultiplicationServiceImpl(private val registry: MultiplicationServiceComponent):
    MultiplicationService {
    override fun product(factor1: Int, factor2: Int): Int {
        if (factor1 == 0 || factor2 == 0) {
            return 0
        }

        val (range, negative) = if (factor1 < 0) {
            Pair(-1 downTo factor1, true)
        } else {
            Pair(1..factor1, false)
        }

        var result: Int = 0
        range.forEach { result = registry.additionService.sum(result, factor2) }
        return if (negative) registry.minusService.minus(result) else result
    }
}