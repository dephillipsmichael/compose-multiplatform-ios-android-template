
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import resources.KmpRes
import resources.stringResource

@Composable
fun ArticleDetail(
    modifier: Modifier = Modifier,
    article: Article?,
    author: Author?,
    openUrl: (String) -> Unit,
    onSelectAuthor: (Author?) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (article != null) {
            article.thumbnail?.let { thumbnail ->
                item {
                    // TODO replace async image
//                    AsyncImage(
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(thumbnail)
//                            .crossfade(true)
//                            .size(Size.ORIGINAL)
//                            .build(),
//                        contentDescription = stringResource(R.string.profile_image_description),
//                        contentScale = ContentScale.Crop
//                    )
                }
            }
            article.description?.let { description ->
                item {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 18.sp
                        )
                    )
                }
            }
            article.articleUrl?.let { articleUrl ->
                item {
                    Text(
                        modifier = Modifier
                            .clickable { openUrl(articleUrl) },
                        text = stringResource(KmpRes.string.read_more_ellipsis),
                        textDecoration = TextDecoration.Underline,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        } else {
            item {
                Text(stringResource(KmpRes.string.missing_data_message))
            }
        }
        item {
            AuthorFooter(
                author = author,
                onClick = { onSelectAuthor(author) }
            )
        }
    }
}

@Composable
private fun AuthorFooter(
    modifier: Modifier = Modifier,
    author: Author?,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        author?.let {
            Column(horizontalAlignment = Alignment.End) {
                Text(it.fullName)
                Text(
                    text = stringResource(KmpRes.string.author_disclaimer),
                    style = MaterialTheme.typography.caption
                )
            }
        }
        if (author != null) {
            Spacer(modifier = Modifier.width(8.dp))
            // TODO replace async image
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(author.profileUrl)
//                    .crossfade(true)
//                    .size(Size.ORIGINAL)
//                    .build(),
//                contentDescription = stringResource(R.string.profile_image_description),
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .size(56.dp)
//            )
        } else {
            Icon(
                Icons.Outlined.Person,
                modifier = Modifier.size(56.dp),
                contentDescription = stringResource(KmpRes.string.profile_image_placeholder_description),
            )
        }
    }
}