interface DivisionService {
    fun divide(a: Int, b: Int): Int
}

interface DivisionServiceComponent: SubtractionServiceComponent, AdditionServiceComponent {
    val divisionService: DivisionService
}

class DivisionServiceImpl(private val registry: DivisionServiceComponent): DivisionService {
    override fun divide(a: Int, b: Int): Int {
        var rest = a
        var count: Int = 0
        while(rest > b) {
            rest = registry.subtractionService.difference(rest, b)
            count = registry.additionService.sum(count, 1)
        }
        return count
    }
}