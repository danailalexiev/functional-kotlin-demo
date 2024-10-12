package bg.dalexiev

class UserRepository (private val database: Database) {
    
    fun findUserById(id: Long): User? =
        database.executeQuery("select * from user where id=$id")?.let { 
            User(
                id = it["id"] as Long,
                name = it["name"] as String,
                email = it["email"] as String,
                password = it["password"] as String
            )
        }
    
}