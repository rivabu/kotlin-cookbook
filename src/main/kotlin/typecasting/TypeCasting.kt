package typecasting

import java.text.DecimalFormat
import java.time.LocalDate
import java.util.logging.Handler

fun main() {
    typeCasting("Privet")
    typeCasting(145)
    typeCasting(145.0)
    typeCasting(145.2817812)
    typeCasting(LocalDate.of(1990, 1, 1))
    typeCasting(Handler::class)

    typeCasting(LocalDate.of(2006, 12, 24))
}

fun typeCasting(obj: Any?) {
    obj ?: return println("Объект равен null")

    val tinekEstimated = LocalDate.of(2006, 12, 24)
    val suffix = when (obj) {
        is String -> "длина равна ${obj.length}"
        is Int -> "его квадрат равен ${obj * obj}"
        is Double -> "это число округляется до ${DecimalFormat("#.##").format(obj)}"
        is LocalDate -> {
            if (obj < tinekEstimated) "эта дата меньше чем дата основания Tinkoff"
            else if (obj == tinekEstimated) "это дата основания Tinkoff!"
            else "эта дата больше чем дата основания Tinkoff"
        }

        else -> return println("Мне этот тип неизвестен")
    }
    println("Я получил тип ${obj::class.simpleName} = $obj, $suffix")
}

