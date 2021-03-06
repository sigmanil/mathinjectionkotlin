package smn.mathinjectionkotlin

import io.mockk.mockk
import smn.mathinjectionkotlin.service.*

open class DefaultTestRegistry: ComponentRegistry {
    override val subtractionService = mockk<SubtractionService>()
    override val additionService = mockk<AdditionServiceImpl>()
    override val divisionService = mockk<DivisionService>()
    override val multiplicationService = mockk<MultiplicationService>()
    override val exponentiationService = mockk<ExponentiationService>()
    override val minusService = mockk<MinusService>()
}