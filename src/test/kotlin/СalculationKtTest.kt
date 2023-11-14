import org.junit.Test

import org.junit.Assert.*

class СalculationKtTest {

    @Test
    fun runVisa() {
        val typePaySystem = "Visa" //MasterCard, Visa, Mir, VKPay
        val amount = 3500
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Комиссия составит: 35 руб.", result)
    }
    @Test
    fun runVisaSmallCommission() {
        val typePaySystem = "Visa" //MasterCard, Visa, Mir, VKPay
        val amount = 10000
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Комиссия составит: 75 руб.", result)
    }
    @Test
    fun runMasterCardLimitDay() {
        val typePaySystem = "MasterCard" //MasterCard, Visa, Mir, VKPay
        val amount = 200000
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Слишком большая сумма для перевода", result)
    }
    @Test
    fun runMasterNoCommission() {
        val typePaySystem = "MasterCard" //MasterCard, Visa, Mir, VKPay
        val amount = 1000
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Комиссия не взимается", result)
    }

    @Test
    fun runMasterCardLimitMonth() {
        val typePaySystem = "MasterCard" //MasterCard, Visa, Mir, VKPay
        val amount = 2000
        val previousAmount = 3000000
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Превышен месячный лимит по карте", result)
    }
    @Test
    fun runUnKnouwnPaySystem() {
        val typePaySystem = "---" //MasterCard, Visa, Mir, VKPay
        val amount = 200
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Не известная платежная система", result)
    }
    @Test
    fun runMasterCardNoCommission() {
        val typePaySystem = "MasterCard" //MasterCard, Visa, Mir, VKPay
        val amount = 2000
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Комиссия не взимается", result)
    }
    @Test
    fun runMasterCardCommission() {
        val typePaySystem = "MasterCard" //MasterCard, Visa, Mir, VKPay
        val amount = 200
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Комиссия составит: 21 руб.", result)
    }
    @Test
    fun runVK() {
        val typePaySystem = "VKPay" //MasterCard, Visa, Mir, VKPay
        val amount = 2000
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Комиссиия за переводы по VK Pay не взимается", result)
    }
    @Test
    fun runVKLimitOne() {
        val typePaySystem = "VKPay" //MasterCard, Visa, Mir, VKPay
        val amount = 20000
        val previousAmount = 0
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Слишком большая сумма для перевода за один раз", result)
    }
    @Test
    fun runVKLimitMonth() {
        val typePaySystem = "VKPay" //MasterCard, Visa, Mir, VKPay
        val amount = 10000
        val previousAmount = 40000
        val  result = run(typePaySystem, previousAmount,amount)
        assertEquals("Превышен лимит переводов за месяц. С уважением, Ваш VK. ", result)
    }
    @Test
    fun runDefault() {

        val amount = 10000
        val previousAmount = 40000
        val  result = run(amount=amount)
        assertEquals("Комиссиия за переводы по VK Pay не взимается", result)
    }
}