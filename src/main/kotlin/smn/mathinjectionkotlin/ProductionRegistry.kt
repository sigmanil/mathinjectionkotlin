package smn.mathinjectionkotlin

import smn.mathinjectionkotlin.service.*

class ProductionRegistry: ComponentRegistry {
    override val subtractionService: SubtractionService =
        SubtractionServiceImpl(this)
    override val additionService: AdditionService =
        AdditionServiceImpl(this)
    override val multiplicationService: MultiplicationService =
        MultiplicationServiceImpl(this)
    override val divisionService: DivisionService =
        DivisionServiceImpl(this)
    override val powerService: PowerService =
        PowerServiceImpl(this)
    override val minusService: MinusService =
        MinusServiceImpl()
}