package chris.did.presentation.nudgviewmodel

import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodel.tagviewmodel.TagViewModel

/**
 * UserNudgViewModel
 */
class UserNudgViewModel(
    private val nudg: Nudg,
    private val tags: List<TagViewModel>
) : NudgViewModel {
    override fun getId() = nudg.id
    override fun getText() = nudg.text
    override fun getTags() = tags
}
