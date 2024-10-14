package bg.dalexiev

suspend fun Database.findUserById(id: Long): User? =
    executeQuery("select * from user where id=$id")?.let {
        User(
            id = Id(it["id"] as Long),
            name = Name(it["name"] as String),
            email = Email(it["email"] as String),
            password = Password(it["password"] as String)
        )
    }