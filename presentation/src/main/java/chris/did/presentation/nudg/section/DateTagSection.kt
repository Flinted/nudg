package chris.did.presentation.nudg.section

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

/**
 * DateTagSection
 */

data class DateTagSection(override val id: UUID, override val value: String) : Section {
    companion object {
        private val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
    }

    private val date = LocalDate.parse(value.substring(1), formatter)
}
