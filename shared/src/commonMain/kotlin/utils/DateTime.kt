
@kotlinx.serialization.Serializable
expect class DateTime() {
    fun getFormattedDate(
        iso8601Timestamp: String,
        format: String,
    ): String
}