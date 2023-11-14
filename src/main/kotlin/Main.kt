fun main(args: Array<String>) {

    val typePaySystem = "Visa" //MasterCard, Visa, Mir, VKPay

    val amount = 3500

    val previousAmount = 0

    println(run(typePaySystem, previousAmount, amount))
}