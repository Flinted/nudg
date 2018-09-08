package chris.did.nudg.overview

import android.content.Context
import android.widget.Toast
import chris.did.nudg.base.BaseApplication
import chris.did.nudg.base.BaseViewModel
import chris.did.presentation.nudg.Nudg
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

    override fun getNudgs() {
        presenter.getNudgs()
    }

    override fun didGetNudgs(nudgs: List<Nudg>) {
        Toast.makeText(getApplication() as Context, nudgs.first().text, Toast.LENGTH_LONG).show()
    }

    override fun didFailToGetNudgs(exception: Exception) {
    }
}
