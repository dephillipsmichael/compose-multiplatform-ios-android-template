import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import resources.KmpRes
import resources.stringResource

@Composable
fun AuthorProfile(
    modifier: Modifier = Modifier,
    author: Author?,
) {
    LazyColumn(
        modifier = modifier
            .padding(4.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (author != null) {
            item {
                // TODO replace async image
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(author.profileUrl)
//                        .crossfade(true)
//                        .size(Size.ORIGINAL)
//                        .build(),
//                    contentDescription = stringResource(R.string.profile_image_description),
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .clip(CircleShape)
//                        .size(96.dp)
//                )
            }
            item {
                Text(
                    author.fullName
                )
            }
            item {
                Text(
                    text = author.authorIpsum,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        } else {
            item {
                Icon(
                    Icons.Outlined.Person,
                    modifier = Modifier.size(56.dp),
                    contentDescription = stringResource(KmpRes.string.profile_image_placeholder_description),
                )
            }
        }
    }
}