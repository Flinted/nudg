package chris.did.presentation.overview

import chris.did.presentation.base.BaseListener
import chris.did.presentation.nudg.Nudg

/**
 * OverviewPresenterListener
 */
interface OverviewPresenterListener : BaseListener {

    fun didGetNudgs(nudgs: List<Nudg>)
    fun didFailToGetNudgs(exception: Exception)
}
