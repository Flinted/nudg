package chris.did.presentation.nudgviewmodel

import chris.did.presentation.nudgviewmodel.tagviewmodel.TagViewModel
import java.util.*

/**
 * NudgViewModel
 */
interface NudgViewModel {

    fun getId(): UUID
    fun getText(): String
    fun getTags(): List<TagViewModel>
}
