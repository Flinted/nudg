package chris.did.presentation.nudgviewmodel

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * DeletedNudgViewModel
 */
class DeletedNudgViewModel(
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
        builder.setSpan(ForegroundColorSpan(Color.GRAY), 0, builder.length, 0)
        return builder
    }
}
