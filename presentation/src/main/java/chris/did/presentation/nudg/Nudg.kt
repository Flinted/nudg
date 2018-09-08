package chris.did.presentation.nudg

import chris.did.presentation.nudg.tag.Tag


/**
 * Nudg
 */
interface Nudg {
    val text: String
    val tags: List<Tag>
}