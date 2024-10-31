import kotlin.math.PI
import kotlin.math.pow

abstract class Dwelling {
    abstract fun area(): Double
}

class RoundHut(private val radius: Double) : Dwelling() {
    override fun area(): Double {
        return PI * radius.pow(2)
    }
}

class SquareCabin(private val side: Double) : Dwelling() {
    override fun area(): Double {
        return side.pow(2)
    }
}

class RectangleCabin(private val length: Double, private val breadth: Double) : Dwelling() {
    override fun area(): Double {
        return length * breadth
    }
}

class RoundTower(private val radius: Double) : Dwelling() {
    override fun area(): Double {
        return PI * radius.pow(2)
    }
}

class TriangleCabin(private val base: Double, private val height: Double) : Dwelling() {
    override fun area(): Double {
        return 0.5 * base * height
    }
}

fun main() {
    val radiusHut = 4.0
    val roundHut = RoundHut(radiusHut)
    println("Area of Round Hut: ${roundHut.area()}")

    val sideCabin = 4.0
    val squareCabin = SquareCabin(sideCabin)
    println("Area of Square Cabin: ${squareCabin.area()}")

    val lengthCabin = 5.0
    val breadthCabin = 3.0
    val rectangleCabin = RectangleCabin(lengthCabin, breadthCabin)
    println("Area of Rectangle Cabin: ${rectangleCabin.area()}")

    val radiusTower = 8.0
    val roundTower = RoundTower(radiusTower)
    println("Area of Round Tower: ${roundTower.area()}")

    val baseTriangle = 6.0
    val heightTriangle = 4.0
    val triangleCabin = TriangleCabin(baseTriangle, heightTriangle)
    println("Area of Triangle Cabin: ${triangleCabin.area()}")
}
