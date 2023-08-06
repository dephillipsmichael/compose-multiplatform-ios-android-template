import kotlinx.serialization.Serializable

@Serializable
data class AuthorList(
    val authorList: List<Author>
)