import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal val ktorClient = HttpClient() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
}

internal const val ARTICLES_URL = "https://run.mocky.io/v3/b654fa22-d37a-46ac-9fa2-51032ec8aa02"
internal const val AUTHORS_URL = "https://run.mocky.io/v3/a1fc137b-5b9a-4ecf-9122-0d9f5bd0d2b8"

class ArticlesApi(private val client: HttpClient = ktorClient) {
    suspend fun getArticles(): ArticleList {
        return client.get(ARTICLES_URL).body()
    }

    suspend fun getAuthors(): AuthorList {
        return client.get(AUTHORS_URL).body()
    }
}