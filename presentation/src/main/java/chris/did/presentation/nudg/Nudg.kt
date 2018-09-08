package chris.did.presentation.nudg

import chris.did.presentation.nudg.tag.Tag
import java.util.*


/**
 * Nudg
 */
interface Nudg {
    val id: UUID
    val text: String
    val tags: List<Tag>
}
