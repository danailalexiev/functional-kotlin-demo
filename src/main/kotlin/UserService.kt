package bg.dalexiev

import arrow.core.raise.Raise

data class NotFound(val id: Id)

suspend fun <Ctx> Raise<NotFound>.getUserById(context: Ctx, id: Id): User where Ctx : Database, Ctx : Logger =
    context.findUserById(id.value)?.let {
        context.log("User found!")
        it
    } ?: raise(NotFound(id))