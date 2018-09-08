package chris.did.presentation.nudg

import chris.did.presentation.nudg.tag.Tag
import java.util.*

/**
 * DeletedNudg
 */
data class DeletedNudg(
    override val id: UUID,
    override val text: String,
    override val tags: List<Tag>
) : Nudg {
}