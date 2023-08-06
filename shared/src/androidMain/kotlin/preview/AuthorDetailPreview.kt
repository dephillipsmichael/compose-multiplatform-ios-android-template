package preview

import Author
import AuthorProfile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AuthorDetailPreview() {
    AuthorProfile(
        author = Author(
            first = "Kurt",
            id = 0L,
            last = "Vonnegut",
            profileUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Kurt_Vonnegut_1972.jpg/640px-Kurt_Vonnegut_1972.jpg"
        )
    )
}