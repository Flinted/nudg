package chris.did.presentation.nudgviewmodel

import android.text.SpannableStringBuilder
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * UserNudgViewModel
 */
class UserNudgViewModel(
    private val nudg: Nudg,
    private val sections: List<SectionViewModel>
) : NudgViewModel {

    private val builder = getSpannableStringBuilder()
    override fun getId() = nudg.id
    override fun getBuiltText() = builder
    override fun getSections() = sections

    private fun getSpannableStringBuilder(): SpannableStringBuilder {
        val builder = SpannableStringBuilder()
        sections.forEach { section ->
            builder.append(section.getFormattedValue())
        }
        return builder
    }
}
//
//private fun SpannableStringBuilder.append(
//    text: CharSequence,
//    textColorRes: Int ) {
//    val index = length
//    append(text)
//    setSpan(ForegroundColorSpan(textColorRes), index, index + text.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
//}
