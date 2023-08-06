
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
@ExperimentalMaterialApi
fun ArticlesListView(articles: List<Article>, onSelect: (Article) -> Unit) {
    LazyColumn {
        itemsIndexed(articles) { idx, article ->
            val primaryColor: Color = if (idx % 2 == 0) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant
            Card(
                onClick = { onSelect(article) },
                modifier = Modifier
                    .padding(4.dp)
                    .heightIn(max = 192.dp),
                shape = MaterialTheme.shapes.medium.copy(
                    all = CornerSize(12.dp)
                ),
                backgroundColor = primaryColor,
                elevation = 2.dp
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    // TODO replace async image
//                    AsyncImage(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .alpha(0.2f),
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(article.thumbnail)
//                            .crossfade(true)
//                            .size(Size.ORIGINAL)
//                            .build(),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop
//                    )
                    Column(
                        modifier = Modifier.padding(4.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            if (article.openInBrowser) {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = null,
                                    modifier = Modifier.size(36.dp),
                                    tint = MaterialTheme.colors.onPrimary
                                )
                            }
                            Text(
                                text = article.title,
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis,
                                style = typography.h5.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colors.onPrimary
                                ),
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                        article.description?.let {
                            Text(
                                text = it,
                                maxLines = 4,
                                overflow = TextOverflow.Ellipsis,
                                style = typography.body1.copy(
                                    fontWeight = FontWeight.Normal,
                                    color = MaterialTheme.colors.onPrimary
                                ),
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}