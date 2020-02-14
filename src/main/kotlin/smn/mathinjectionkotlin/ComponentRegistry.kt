package smn.mathinjectionkotlin

import smn.mathinjectionkotlin.service.*

interface ComponentRegistry: SubtractionServiceComponent,
    AdditionServiceComponent,
    MultiplicationServiceComponent,
    DivisionServiceComponent,
    PowerServiceComponent,
    MinusServiceComponent