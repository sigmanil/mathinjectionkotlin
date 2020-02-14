interface AdditionService {
  fun sum(term1: Int, term2: Int): Int
}

interface AdditionServiceComponent: SubtractionServiceComponent, MinusServiceComponent {
    val additionService: AdditionService
}

class AdditionServiceImpl(private val registry: AdditionServiceComponent): AdditionService {
    override fun sum(term1: Int, term2: Int): Int {
        return registry.subtractionService.difference(term1, registry.minusService.minus(term2))
    }
}