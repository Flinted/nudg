package chris.did.presentation.nudg

import chris.did.presentation.nudg.section.Section
import java.util.*


/**
 * UserNudg
 */
data class UserNudg(
    override val id: UUID,
    override val sections: List<Section>
) : Nudg
