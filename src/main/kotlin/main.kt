
import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2
const val CARD_DAILY_LIMIT = 150_000
const val CARD_MONTHLY_LIMIT = 600_000
const val VK_PAY_LIMIT_DAY = 15_000
const val VK_PAY_LIMIT_MONTHLY = 40_000
fun main() {

//    println(calculateCommission("VK Pay", 15_000, 0))

    when (val commission = calculateCommission(typeCard = "MasterCard", transfer = 80_000, lastTransfers = 0)) {
        ERROR_TYPE -> println("Тип карты не распознан")
        ERROR_LIMIT -> println("Превышен лимит. Перевод отменен")
        else -> println("Комиссия: $commission")
    }
}

fun calculateCommission(typeCard: String, transfer: Int, lastTransfers: Int):
        Int {
    return when (typeCard) {
        "VK Pay" -> if (transfer > VK_PAY_LIMIT_DAY || (transfer + lastTransfers) > VK_PAY_LIMIT_MONTHLY) {
            return ERROR_LIMIT
        } else 0

        "MasterCard", "Maestro" -> if (transfer > CARD_DAILY_LIMIT || (transfer + lastTransfers) > CARD_MONTHLY_LIMIT) {
            return ERROR_LIMIT
        } else if (transfer + lastTransfers in 300..75_000) 0
        else (transfer * 0.006).toInt() + 20

        "Visa", "Мир" -> if (transfer > CARD_DAILY_LIMIT || (transfer + lastTransfers) > CARD_MONTHLY_LIMIT) {
            return ERROR_LIMIT
        } else max(35, (transfer * 0.0075).toInt())
        else -> return ERROR_TYPE
    }

}


