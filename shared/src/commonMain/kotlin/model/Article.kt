import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: Long,
    val title: String,

    @SerialName("desc")
    val description: String?,

    @SerialName("url")
    val articleUrl: String?,

    val thumbnail: String?,

    @SerialName("publishedOn")
    val publishedDate: String,

    val authorId: Long?,
    val presentation: Presentation?,
) {
    val openInBrowser: Boolean
        get() = articleUrl != null && presentation == Presentation.COMPACT
}

enum class Presentation{
    COMPACT,
    FULL
}