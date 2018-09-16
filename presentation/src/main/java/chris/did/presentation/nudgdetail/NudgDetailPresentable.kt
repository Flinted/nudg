package chris.did.presentation.nudgdetail

import java.util.*

/**
 * NudgDetailPresentable
 */
interface NudgDetailPresentable {

    fun setListener(listener: NudgDetailPresenterListener)
    fun getNudgForId(id: UUID)
}
