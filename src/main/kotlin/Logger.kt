package bg.dalexiev

interface Logger {

    fun log(message: String)

}

fun Logger() = object : Logger {

    override fun log(message: String) {
        println(message)
    }

}