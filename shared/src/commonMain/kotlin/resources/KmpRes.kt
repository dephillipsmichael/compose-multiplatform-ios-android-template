package resources

object KmpRes {
    object string {
        const val profile_image_description = "profile_image_description"
        const val profile_image_placeholder_description = "profile_image_placeholder_description"
        const val read_more_ellipsis = "read_more_ellipsis"
        const val missing_data_message = "missing_data_message"
        const val back = "back"
        const val author_disclaimer = "author_disclaimer"
        const val author_detail_title = "author_detail_title"
        const val organization_name = "organization_name"
        const val description1 = "description1"
        const val description2 = "description2"
        const val description3 = "description3"
        const val description4 = "description4"

        val en = mapOf(
            profile_image_description to "Authors profile image",
            profile_image_placeholder_description to "Author profile image placeholder",
            read_more_ellipsis to "Read more…",
            missing_data_message to "Oops. Something seems to be missing here.",
            back to "Back",
            author_disclaimer to "Note: Authors are for demonstration purposes.",
            author_detail_title to "Profile",
            organization_name to "InRhythm",
            description1 to "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed dapibus ante eu quam malesuada congue. Nam sodales velit sit amet risus pharetra, at lobortis odio dictum. Fusce nec enim vel mi placerat pretium.",
            description2 to "Phasellus tristique convallis erat vel malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque sit amet urna id purus malesuada egestas. Nulla vehicula justo eget ipsum blandit lacinia.",
            description3 to "Nunc laoreet, nisi quis efficitur bibendum, lorem urna malesuada tortor, vel iaculis nisl felis in magna. Vivamus lobortis, mauris vel venenatis molestie, eros nulla lacinia elit, sit amet dictum turpis enim ut nibh. Suspendisse consectetur dapibus dolor, vel iaculis augue elementum ut. Quisque porta odio quis quam rutrum tempus.",
            description4 to "Aliquam nec tristique ipsum. Sed vel ex auctor, gravida nisi sit amet, semper ipsum. Aenean nec libero non nibh mattis bibendum. Integer a luctus enim, id sagittis quam."
        )
    }
}

fun stringResource(key: String): String {
    // In a real app this would be expect/actual checking Locale and using different language map
    return KmpRes.string.en[key] ?: ""
}