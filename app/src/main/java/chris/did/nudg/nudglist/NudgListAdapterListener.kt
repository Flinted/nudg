package chris.did.nudg.nudglist

import java.util.*

/**
 * NudgListAdapterListener
 */
interface NudgListAdapterListener {

    fun onNudgSelected(id: UUID)
    fun onTagSelected(id: UUID)
}