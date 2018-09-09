package chris.did.presentation.nudgviewmodel

import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.sectionviewmodel.SectionViewModel

/**
 * DeletedNudgViewModel
 */
class DeletedNudgViewModel(
    private val nudg: Nudg,
    private val tags: List<SectionViewModel>
) : NudgViewModel {
    override fun getId() = nudg.id
    override fun getText() = nudg.text.first()
    override fun getTags() = tags
}
