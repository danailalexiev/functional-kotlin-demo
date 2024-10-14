package bg.dalexiev

import arrow.core.Either
import arrow.core.raise.either
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // this part is usually handled by a DI framework
    val database = Database()
    val logger = Logger();
    val context = object : Database by database, Logger by logger {}

    val id = Id(1L)
    val result = either { getUserById(context, id) }
    when (result) {
        is Either.Left -> println("No user found with id ${result.value.id.value}")
        is Either.Right -> println(result.value)
    }
}