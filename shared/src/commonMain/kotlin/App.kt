
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import resources.KmpRes
import resources.stringResource

enum class Page {
    LOADING,
    ARTICLE_LIST,
    ARTICLE,
    AUTHOR;

    companion object {
        // TODO: move this navigation logic over to Voyager and ViewModel
        fun getPage(
            articleList: ArticleList?,
            authorList: AuthorList?,
            article: Article?,
            author: Author?
        ): Page {
            if (articleList == null || authorList == null) {
                return LOADING
            } else if (author != null) {
                return AUTHOR
            } else if (article != null) {
                return ARTICLE
            } else {
                return ARTICLE_LIST
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {

    LightningTalkTheme {
        val uriHandler = LocalUriHandler.current
        var title: String? by remember { mutableStateOf(null) }

        var articlesState by remember { mutableStateOf<ArticleList?>(null) }
        var authorsState by remember { mutableStateOf<AuthorList?>(null) }

        var articleDetail by remember { mutableStateOf<Article?>(null) }
        var authorDetail by remember { mutableStateOf<Author?>(null) }

        LaunchedEffect(Unit) {
            val api = ArticlesApi()
            authorsState = api.getAuthors()
            articlesState = api.getArticles()
        }

        val navIcon: @Composable (() -> Unit) = {
            IconButton(onClick = {
                if (authorDetail != null) {
                    authorDetail = null
                } else {
                    articleDetail = null
                }
                title = null
            }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(KmpRes.string.back)
                )
            }
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background,
            topBar = {
                val appBarTitle = title?.takeIf {
                    articleDetail != null || authorDetail != null
                }
                val appBarIcon = if (appBarTitle == null) null else navIcon
                TopAppBar(
                    title = {
                        Text(
                            appBarTitle ?: stringResource(KmpRes.string.organization_name),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = appBarIcon,
                    elevation = 4.dp
                )
            }
        ) { paddingValues ->

            when (Page.getPage(articlesState, authorsState, articleDetail, authorDetail)) {
                Page.LOADING -> {
                    title = null
                    LoadingView()
                }
                Page.AUTHOR -> {
                    title = stringResource(KmpRes.string.author_detail_title)
                    AuthorProfile(author = authorDetail)
                }
                Page.ARTICLE -> {
                    title = articleDetail?.title
                    ArticleDetail(
                        article = articleDetail,
                        author = authorsState?.authorList?.firstOrNull() {
                            it.id == articleDetail?.authorId
                        },
                        openUrl = { articleUri ->
                            uriHandler.openUri(articleUri)
                        },
                        onSelectAuthor = {
                            authorDetail = it
                        }
                    )
                }
                Page.ARTICLE_LIST -> {
                    title = null
                    ArticlesListView(
                        articles = articlesState!!.articleList,
                        onSelect = { article ->
                            if (article.openInBrowser) {
                                article.articleUrl?.let { uri ->
                                    uriHandler.openUri(uri)
                                }
                            } else {
                                articleDetail = article
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}