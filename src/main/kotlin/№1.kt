import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру 'Камень-Ножницы-Бумага'!")

    while (true) {
        println("Выберите свой вариант:")
        println("1 - Камень")
        println("2 - Ножницы")
        println("3 - Бумага")
        println("0 - Выход из игры")

        val playerChoice = readLine()?.toIntOrNull()!!

        if (playerChoice !in 0..3) {
            println("Неверный выбор, попробуйте еще раз.")
            continue
        }

        if (playerChoice == 0) {
            println("Игра завершена.")
            break
        }

        val computerChoice = Random.nextInt(1, 4)

        println("Компьютер выбрал: ${getChoiceName(computerChoice)}")
        println("Вы выбрали: ${getChoiceName(playerChoice)}")

        val result = getResult(playerChoice, computerChoice)
        when (result) {
            0 -> println("Ничья!")
            1 -> println("Вы победили!")
            -1 -> println("Вы проиграли!")
        }

        println()
    }
}

fun getChoiceName(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Неверный выбор"
    }
}

fun getResult(playerChoice: Int, computerChoice: Int): Int {
    if (playerChoice == computerChoice) {
        return 0 // Ничья
    }

    return when (playerChoice) {
        1 -> if (computerChoice == 2) 1 else -1
        2 -> if (computerChoice == 3) 1 else -1
        3 -> if (computerChoice == 1) 1 else -1
        else -> 0
    }
}
