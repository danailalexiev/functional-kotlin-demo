package bg.dalexiev

fun main() {
    // this part is usually handled by a DI framework
    val database = Database()
    val logger = Logger();

    val id = Id(2L);
    val result = with(object : Database by database, Logger by logger {}) {
        getUserById(id)
    }
    when (result) {
        is FindUserResult.Found -> println(result.user)
        is FindUserResult.NotFound -> println("No user found with id ${result.id.value}")
    }
}