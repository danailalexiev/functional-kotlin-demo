package bg.dalexiev

fun main() {
    // this part is usually handled by a DI framework
    val database = Database()
    val userRepository = UserRepository(database)
    val userService = UserService(userRepository)
    
    val user = userService.getUserById(1L)
    println(user)
}