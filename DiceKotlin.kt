import kotlin.random.Random

class Dice(private val sides: Int = 6) {
    fun roll(): Int {
        return Random.nextInt(1, sides + 1)
    }
}

fun main() {
    val dice = Dice()
    println("Rolling the dice...")
    val result = dice.roll()
    println("You rolled a $result!")
}
