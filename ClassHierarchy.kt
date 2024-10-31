open class Animal(val name: String) {
    open fun makeSound() {
        println("$name makes a sound.")
    }
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name barks!")
    }
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name meows!")
    }
}

fun main() {
    val dog = Dog("husky")
    val cat = Cat("cat")

    dog.makeSound()
    cat.makeSound()
}
