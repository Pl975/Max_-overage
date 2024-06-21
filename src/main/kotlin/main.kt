package ru.netology

import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2
const val typeCard = "Мир"
const val lastTransfers = 0
const val transfer = 150_000
const val dailyLimit = 150_000
const val monthlyLimit = 600_000
fun main() {

    val commission = calculateCommission(typeCard, transfer, lastTransfers)
    if (transfer <= dailyLimit && (transfer + lastTransfers) <= monthlyLimit) {
        println("Сумма перевода: $transfer\nКомиссия: $commission")
    } else {
        println("Превышен лимит. Перевод отменен")
        return
    }
}

fun calculateCommission(typeCard: String, transfer: Int, lastTransfers: Int):
        Int {
    if (transfer > dailyLimit || (transfer + lastTransfers) > monthlyLimit) {
        return ERROR_LIMIT
    }

    return when (typeCard) {
        "Мир" -> return 0
        "MasterCard" -> if (transfer + lastTransfers <= 75_000) 0 else ((transfer + lastTransfers - 75_000) * 0.006).toInt() + 20
        "Visa" -> max(35, (transfer * 0.0075).toInt())
        else -> return ERROR_TYPE
    }
}


