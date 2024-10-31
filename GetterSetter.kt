class Greeting {
    companion object {
        var name: String = ""
            get() = field
            set(value) {
                field = value
            }
        var message: String = ""
            get() = field
            set(value) {
                field = value
            }
        val greet: String
            get() = "$message $name"
    }
}

fun main() {
    Greeting.name = "CVR"
    Greeting.message = "Hello"
    println("name:" + Greeting.name)
    println("message: " + Greeting.message)
    println(Greeting.greet)
}
