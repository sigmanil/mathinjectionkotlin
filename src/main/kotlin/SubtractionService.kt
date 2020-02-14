import java.lang.IllegalArgumentException

interface SubtractionService {
    fun difference(minuend: Int, subtrahend: Int): Int
}

interface SubtractionServiceComponent {
    val subtractionService: SubtractionService
}

class SubtractionServiceImpl: SubtractionService {
    override fun difference(minuend: Int, subtrahend: Int): Int {
        if (minuend < subtrahend) {
            throw IllegalArgumentException("Result would be negative")
        }
        return (subtrahend until minuend).count()
    }
}