import io.mockk.mockk

open class DefaultTestRegistry: ComponentRegistry {
    override val subtractionService = mockk<SubtractionService>()
    override val additionService = mockk<AdditionServiceImpl>()
    override val divisionService = mockk<DivisionService>()
    override val multiplicationService = mockk<MultiplicationService>()
    override val powerService = mockk<PowerService>()
    override val minusService = mockk<MinusService>()
}