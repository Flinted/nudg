package chris.did.presentation.nudgviewmodel

import android.text.SpannableStringBuilder
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel
import java.util.*

/**
 * NudgViewModel
 */
interface NudgViewModel {

    fun getId(): UUID
    fun getBuiltText(): SpannableStringBuilder
    fun getSections(): List<SectionViewModel>
}
