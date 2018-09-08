package chris.did.presentation.nudg

import chris.did.presentation.nudg.tag.Tag


/**
 * UserNudg
 */
data class UserNudg(override val text: String, override val tags: List<Tag>) : Nudg {
}
