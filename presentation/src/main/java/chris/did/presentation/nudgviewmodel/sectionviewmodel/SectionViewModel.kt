package chris.did.presentation.nudgviewmodel.sectionviewmodel

import android.text.SpannableString
import java.util.*

/**
 * SectionViewModel
 */
interface SectionViewModel {

    fun getId(): UUID
    fun getFormattedValue(): SpannableString
}
