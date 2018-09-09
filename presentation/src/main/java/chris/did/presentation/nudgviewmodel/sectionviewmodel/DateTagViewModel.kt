package chris.did.presentation.nudgviewmodel.sectionviewmodel

import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import chris.did.presentation.nudg.section.Section

/**
 * DateTagViewModel
 */
class DateTagViewModel(private val tag: Section) : SectionViewModel {

    override fun getId() = tag.id
    override fun getFormattedValue() = colouredSpannable
    private val colouredSpannable = createSpannable()

    private fun createSpannable(): SpannableString {
        val spannable = SpannableString(tag.value)
        spannable.apply {
            setSpan(ForegroundColorSpan(Color.MAGENTA), 0, tag.value.length, 0)
            setSpan(StyleSpan(Typeface.BOLD), 0, tag.value.length, 0)
        }
        return spannable
    }
}
