package bg.dalexiev

data class User(
    val id: Id,
    val name: Name,
    val email: Email,
    val password: Password,
)

@JvmInline value class Id(val value: Long)
@JvmInline value class Name(val value: String)
@JvmInline value class Email(val value: String)
@JvmInline value class Password(val value: String)