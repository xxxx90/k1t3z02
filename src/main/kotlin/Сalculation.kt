fun run(typePaySystem: String = "VKPay", previousAmount: Int = 0, amount: Int): String {

    //   val typePaySystem
    val limitDay = 150_000
    val limitMonth = 600_000
    val limitVkOne = 15_000
    val limitVkMonth = 40_000

    if (amount > limitDay) {
        return "Слишком большая сумма для перевода"
    }
    if (((previousAmount + amount) > limitMonth)) {
        return "Превышен месячный лимит по карте"
    }

    if (typePaySystem == "MasterCard" || typePaySystem == "Maestro") {
        if (previousAmount + amount > 300 && previousAmount + amount < 75000) {
            return "Комиссия не взимается"
        } else {
            return "Комиссия составит: " + ((amount * 0.006).toInt() + 20) + " руб."
        }
    }

    if (typePaySystem == "Visa" || typePaySystem == "Mir") {
        var commmission = 35
        if ((amount * 0.0075) > 35) {
            commmission = (amount * 0.0075).toInt()
        }

        return "Комиссия составит: " + commmission + " руб."
    }

    if (typePaySystem == "VKPay") {
        if (amount > limitVkOne) {
            return "Слишком большая сумма для перевода за один раз"
        }
        if (previousAmount + amount > limitVkMonth) {
            return "Превышен лимит переводов за месяц. С уважением, Ваш VK. "
        }
        return "Комиссиия за переводы по VK Pay не взимается"

    }

    return "Не известная платежная система"
}