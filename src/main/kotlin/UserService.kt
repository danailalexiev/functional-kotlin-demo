package bg.dalexiev

class UserNotFoundException(id: Long) : RuntimeException("No user with id $id found")

class UserService (private val userRepository: UserRepository) {
    
    fun getUserById(id: Long): User =
        userRepository.findUserById(id) ?: throw UserNotFoundException(id)
    
}