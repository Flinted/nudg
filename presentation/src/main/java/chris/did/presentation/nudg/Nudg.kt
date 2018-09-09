package chris.did.presentation.nudg

import chris.did.presentation.nudg.section.Section
import java.util.*


/**
 * Nudg
 */
interface Nudg {
    val id: UUID
    val sections: List<Section>
}
