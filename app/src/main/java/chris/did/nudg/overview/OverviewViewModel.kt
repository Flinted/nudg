package chris.did.nudg.overview

import chris.did.nudg.base.BaseApplication
import chris.did.nudg.base.BaseViewModel
import chris.did.presentation.overview.OverviewPresentable
import chris.did.presentation.overview.OverviewPresenterListener

/**
 * OverviewViewModel
 */
class OverviewViewModel(
    application: BaseApplication,
    private val presenter: OverviewPresentable
) : BaseViewModel(application), OverviewViewModellable, OverviewPresenterListener {

    init {
        this.presenter.setListener(this)
    }
}
