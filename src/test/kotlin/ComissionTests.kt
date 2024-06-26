import org.junit.Assert.assertEquals
import org.junit.Test

class ComissionTests {

    @Test
    fun testMasterCardMinLimit() {
        val typeCard = "MasterCard"
        val transfer = 200
        val lastTransfers = 0

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(21, result)
    }

    @Test
    fun testMasterCardMaxLimit() {
        val typeCard = "MasterCard"
        val transfer = 80_000
        val lastTransfers = 0

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(500, result)
    }

    @Test
    fun testMasterCardTransfer() {
        val typeCard = "MasterCard"
        val transfer = 500
        val lastTransfers = 0

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(0, result)
    }

    @Test
    fun testWrongType() {
        val typeCard = "Master"
        val transfer = 80_000
        val lastTransfers = 0

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(ERROR_TYPE, result)
    }

    @Test
    fun testMasterCardWrongLimitDay() {
        val typeCard = "MasterCard"
        val transfer = 151_000
        val lastTransfers = 0

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testMasterCardWrongLimitMonth() {
        val typeCard = "MasterCard"
        val transfer = 80_000
        val lastTransfers = 600_000

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testVkPayWrongLimitDay() {
        val typeCard = "VK Pay"
        val transfer = 20_000
        val lastTransfers = 0

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testVkPayWrongLimitMonth() {
        val typeCard = "VK Pay"
        val transfer = 10_000
        val lastTransfers = 100_000

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testVkPayWTransfer() {
        val typeCard = "VK Pay"
        val transfer = 10_000
        val lastTransfers = 10_000

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(0, result)
    }

    @Test
    fun testVisaWrongLimitDay() {
        val typeCard = "Visa"
        val transfer = 200_000
        val lastTransfers = 0

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testVisaWrongLimitMonth() {
        val typeCard = "Visa"
        val transfer = 10_000
        val lastTransfers = 700_000

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testVVisaTransfer() {
        val typeCard = "Visa"
        val transfer = 10_000
        val lastTransfers = 10_000

        val result = calculateCommission(typeCard, transfer, lastTransfers)
        assertEquals(75, result)
    }

}