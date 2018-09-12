package chris.did.presentation.nudg

import chris.did.presentation.nudg.section.Section
import java.util.*

/**
 * DeletedNudg
 */
data class DeletedNudg(
    override val id: UUID,
    override val text: String,
    override val notes: String,
    override val sections: List<Section>
) : Nudg
