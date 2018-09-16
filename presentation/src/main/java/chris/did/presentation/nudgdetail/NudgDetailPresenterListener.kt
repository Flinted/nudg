package chris.did.presentation.nudgdetail

import chris.did.presentation.base.BaseListener
import chris.did.presentation.nudgviewmodel.NudgViewModel

/**
 * NudgDetailPresenterListener
 */
interface NudgDetailPresenterListener: BaseListener {

    fun onGetNudgSuccess(nudgViewModel: NudgViewModel)
    fun onGetNudgFailure(exception: Exception)
}