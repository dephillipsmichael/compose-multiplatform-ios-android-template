import kotlinx.serialization.Serializable
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSISO8601DateFormatter
import platform.Foundation.NSTimeZone
import platform.Foundation.systemTimeZone

@Serializable
actual class DateTime actual constructor() {
    private val iso8601Formatter by lazy { NSISO8601DateFormatter() }
    private val dateFormatter by lazy {
        NSDateFormatter().apply {
            timeZone = NSTimeZone.systemTimeZone()
        }
    }

    actual fun getFormattedDate(
        iso8601Timestamp: String,
        format: String
    ): String {
        val date = iso8601Formatter.dateFromString(iso8601Timestamp)
        return date?.let {
            dateFormatter.dateFormat = format
            dateFormatter.stringFromDate(it)
        } ?: "--"
    }
}