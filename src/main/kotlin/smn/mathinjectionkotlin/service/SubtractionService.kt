package smn.mathinjectionkotlin.service

interface SubtractionService {
    fun difference(minuend: Int, subtrahend: Int): Int
}

interface SubtractionServiceComponent: MinusServiceComponent {
    val subtractionService: SubtractionService
}

class SubtractionServiceImpl(private val registry: SubtractionServiceComponent):
    SubtractionService {
    override fun difference(minuend: Int, subtrahend: Int): Int {
        if (minuend < subtrahend) {
            return registry.minusService.minus((minuend until subtrahend).count())
        } else {
            return (subtrahend until minuend).count()
        }
    }
}