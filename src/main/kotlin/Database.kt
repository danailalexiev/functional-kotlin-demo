package bg.dalexiev

interface Database {

    fun executeQuery(query: String): Map<String, Any>?

}

fun Database(): Database = object : Database {

    override fun executeQuery(query: String): Map<String, Any>? =
        if ("select * from user where id=1" == query) {
            mapOf(
                "id" to 1L,
                "name" to "Danail Alexiev",
                "email" to "danail.lxv@gmail.com",
                "password" to "Secret123"
            )
        } else {
            null
        }

}