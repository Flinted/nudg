package chris.did.presentation.overview

import chris.did.presentation.base.BasePresenter
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.usecase.Failure
import chris.did.presentation.usecase.GetNudgsUseCase
import chris.did.presentation.usecase.UseCase.None
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/**
 * OverviewPresenter
 */
class OverviewPresenter(private val getNudgsUseCase: GetNudgsUseCase, private val uiContext: CoroutineContext) :
    BasePresenter<OverviewPresenterListener>(), OverviewPresentable {

    override fun getNudgs() {
        getNudgsUseCase.invoke(None()) {it.either(::onGetNudgsFailure, ::onGetNudgsSuccess)}
    }

    private fun onGetNudgsSuccess(nudgs: List<Nudg>) {
        launch(uiContext) {
            presenterListener?.didGetNudgs(nudgs)
        }
    }

    private fun onGetNudgsFailure(failure: Failure) {
        launch(uiContext) {
            presenterListener?.didFailToGetNudgs(Exception())
        }
    }
}
