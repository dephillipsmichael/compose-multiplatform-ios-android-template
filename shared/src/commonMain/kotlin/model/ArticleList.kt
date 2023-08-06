import kotlinx.serialization.Serializable

@Serializable
data class ArticleList(
    val articleList: List<Article>
)
