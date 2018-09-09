package chris.did.presentation.nudgviewmodel

import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * UserNudgViewModel
 */
class UserNudgViewModel(
    private val nudg: Nudg,
    private val tags: List<SectionViewModel>
) : NudgViewModel {
    override fun getId() = nudg.id
    override fun getText() = nudg.sections.first().value
    override fun getTags() = tags
}
