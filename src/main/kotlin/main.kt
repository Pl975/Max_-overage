package ru.netology

fun main() {

    val typeCard = "Мир"
    val lastTransfers = 0
    val transfer = 150_000
    val dailyLimit = 150_000
    val monthlyLimit = 600_000
    val commission = calculateCommission(typeCard, lastTransfers, transfer)
    if (transfer <= dailyLimit && transfer <= monthlyLimit) {
        println("Сумма перевода: $transfer" + "\nКомиссия: $commission")
    }
    else {
        println("Превышен лимит. Перевод отменен")
        return
    }
}

fun calculateCommission(typeCard: String, lastTransfers: Int, transfer: Int):
        Int {
    when (typeCard) {
        "Мир" -> return 0
        "MasterCard" -> {
            if ((lastTransfers + transfer) > 75_000) {
                return ((transfer - 75_000) * 0.006 + 20).toInt()
            } else {
                return 0
            }
        }

        "Visa" -> (transfer * 0.0075).toInt()
        else -> {
            return 0
        }
    }
    return 0
}
