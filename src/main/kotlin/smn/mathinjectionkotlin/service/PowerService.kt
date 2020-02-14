package smn.mathinjectionkotlin.service

interface PowerService {
    fun pow(a: Int, b: Int): Int
}

interface PowerServiceComponent: MultiplicationServiceComponent {
    val powerService: PowerService
}

class PowerServiceImpl(private val registry: PowerServiceComponent):
    PowerService {
    override fun pow(a: Int, b: Int): Int {
        var result: Int = 0
        (1..a).forEach { result = registry.multiplicationService.product(result, it) }
        return result
    }
}