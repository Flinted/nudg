package chris.did.presentation.nudg.tag

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

/**
 * DateTag
 */

data class DateTag(override val id: UUID, override val tag: String) : Tag {
    companion object {
        private val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
    }

    private val date = LocalDate.parse(tag, formatter)
}
