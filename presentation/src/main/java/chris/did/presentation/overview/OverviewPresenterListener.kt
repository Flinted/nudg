package chris.did.presentation.overview

import chris.did.presentation.base.BaseListener
import chris.did.presentation.nudgviewmodel.NudgViewModel

/**
 * OverviewPresenterListener
 */
interface OverviewPresenterListener : BaseListener {

    fun didGetNudgs(nudgs: List<NudgViewModel>)
    fun didFailToGetNudgs(exception: Exception)
    fun didSaveNudg()
    fun didFailToSaveNudg()
    fun didFindInvalidNudgInput()
    fun didFindValidNudgInput()
}
