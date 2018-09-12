package chris.did.presentation.nudgviewmodel

import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * DeletedNudgViewModel
 */
class DeletedNudgViewModel(
    private val nudg: Nudg,
    private val sections: List<SectionViewModel>
) : NudgViewModel {
    override fun getId() = nudg.id
    override fun getBuiltText() = nudg.text
    override fun getNotes() = nudg.notes
    override fun getSections() = sections
    override fun getSectionsText(): String {
        val builder = StringBuilder()
        sections.forEach {
            builder.append(it.getFormattedValue())
        }
        return builder.toString()
    }
}
