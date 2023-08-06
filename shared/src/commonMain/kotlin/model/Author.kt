import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable
import resources.KmpRes
import resources.stringResource

@Serializable
data class Author(
    val first: String,
    val id: Long,
    val last: String,
    val profileUrl: String
) {
    val fullName = "$first $last"
}

private fun determineIndex(authorId: Int, count: Int): Int = (authorId * 7 + 3) % count

val Author.authorIpsum: String
    @Composable
    get() {
        val ipsumStrings = listOf(
            stringResource(KmpRes.string.description1),
            stringResource(KmpRes.string.description2),
            stringResource(KmpRes.string.description3),
            stringResource(KmpRes.string.description4)
        )
        val ipsumIndex = determineIndex(id.toInt(), ipsumStrings.size)
        return ipsumStrings[ipsumIndex]
    }