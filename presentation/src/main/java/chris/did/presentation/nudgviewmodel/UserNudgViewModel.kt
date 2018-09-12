package chris.did.presentation.nudgviewmodel

import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * UserNudgViewModel
 */
class UserNudgViewModel(
    private val nudg: Nudg,
    private val sections: List<SectionViewModel>
) : NudgViewModel {
    private val sectionsText = createSectionsText()

    override fun getId() = nudg.id
    override fun getBuiltText() = nudg.text
    override fun getNotes() = nudg.notes
    override fun getSections() = sections
    override fun getSectionsText() = sectionsText

    private fun createSectionsText(): String {
        val builder = StringBuilder()
        sections.forEach {
            builder.append(it.getFormattedValue())
            builder.append(" ")
        }
        builder.dropLast(1)
        return builder.toString()
    }
}
