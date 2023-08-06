import android.os.Build
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@kotlinx.serialization.Serializable
actual class DateTime {

   actual fun getFormattedDate(
        iso8601Timestamp: String,
        format: String,
    ): String {
        val date = getDateFromIso8601Timestamp(iso8601Timestamp)
        val formatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            DateTimeFormatter.ofPattern(format)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
       return date.format(formatter)
    }

    private fun getDateFromIso8601Timestamp(string: String): ZonedDateTime {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ZonedDateTime.parse(string)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
    }
}