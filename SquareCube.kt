fun calculateSquareAndCube(number: Int?) {
    if (number != null) {
        val square = number * number
        val cube = number * number * number
        println("Square of $number is $square")
        println("Cube of $number is $cube")
    } else {
        println("Number is null, cannot calculate square or cube.")
    }
}

fun main() {
    val number1: Int? = 5
    val number2: Int? = null

    println("Calculations for number1:")
    calculateSquareAndCube(number1)

    println("\nCalculations for number2:")
    calculateSquareAndCube(number2)
}
