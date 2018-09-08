package chris.did.presentation.nudg

import chris.did.presentation.nudg.tag.Tag

/**
 * DeletedNudg
 */
class DeletedNudg(
    override val text: String,
    override val tags: List<Tag>
) : Nudg {
}