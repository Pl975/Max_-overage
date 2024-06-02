package ru.netology

fun main() {
    val amount = 100_000 // сумма перевода в рублях
    val minCommission = 35 // минимальная комиссия

    var transferAmount: Int = (amount * 0.0075).toInt()

    if (transferAmount < minCommission) {
        transferAmount = minCommission
    }

    println(
        """Сумма перевода: $amount руб.
            Комиссия: $transferAmount руб."""
    )
}