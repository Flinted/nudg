package chris.did.presentation.nudgviewmodel.sectionviewmodel

import android.text.SpannableString
import chris.did.presentation.nudg.section.Section

/**
 * StringSectionViewModel
 */
class StringSectionViewModel(private val stringSection: Section) : SectionViewModel {

    override fun getId() = stringSection.id
    override fun getFormattedValue() = colouredSpannable
    private val colouredSpannable = createSpannable()

    private fun createSpannable(): SpannableString {
        return SpannableString(stringSection.value)
    }
}
