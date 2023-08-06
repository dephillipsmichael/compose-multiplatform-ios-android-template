import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
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
                KamelImage(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(96.dp),
                    resource = asyncPainterResource(data = author.profileUrl as Any),
                    contentDescription = stringResource(KmpRes.string.profile_image_description),
                    contentScale = ContentScale.Crop,
                    animationSpec = tween(),
                    onLoading = { PersonIcon() },
                    onFailure = { PersonIcon() }
                )
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
                PersonIcon()
            }
        }
    }
}

@Composable
fun PersonIcon() {
    Icon(
        Icons.Outlined.Person,
        modifier = Modifier.size(56.dp),
        contentDescription = stringResource(KmpRes.string.profile_image_placeholder_description),
    )
}