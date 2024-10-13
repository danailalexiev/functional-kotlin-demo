package bg.dalexiev

sealed interface FindUserResult {

    data class NotFound(val id: Id) : FindUserResult

    data class Found(val user: User) : FindUserResult

}

fun <Ctx> Ctx.getUserById(id: Id): FindUserResult where Ctx : Database, Ctx : Logger =
    findUserById(id.value)?.let {
        log("User found!")
        FindUserResult.Found(it)
    } ?: FindUserResult.NotFound(id)


