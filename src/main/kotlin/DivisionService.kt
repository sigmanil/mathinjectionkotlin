interface DivisionService {
    fun quotientAndRemainder(dividend: Int, divisor: Int): Pair<Int,Int>

}

interface DivisionServiceComponent: SubtractionServiceComponent, AdditionServiceComponent {
    val divisionService: DivisionService
}

class DivisionServiceImpl(private val registry: DivisionServiceComponent): DivisionService {
    override fun quotientAndRemainder(dividend: Int, divisor: Int): Pair<Int,Int> {
        var remainder = dividend
        var count: Int = 0
        while(remainder > divisor) {
            remainder = registry.subtractionService.difference(remainder, divisor)
            count = registry.additionService.sum(count, 1)
        }
        return Pair(count, remainder)
    }
}