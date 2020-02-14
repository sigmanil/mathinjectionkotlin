package smn.mathinjectionkotlin.service

interface MinusService {
    fun minus(operand: Int): Int
}

interface MinusServiceComponent {
    val minusService: MinusService
}

class MinusServiceImpl: MinusService {
    override fun minus(operand: Int): Int {
        return -operand
    }
}