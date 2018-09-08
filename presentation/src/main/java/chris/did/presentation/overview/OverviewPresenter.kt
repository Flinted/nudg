package chris.did.presentation.overview

import chris.did.presentation.base.BasePresenter
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgviewmodelfactory.NudgViewModelCreator
import chris.did.presentation.overview.usecases.GetNudgsUseCase
import chris.did.presentation.overview.usecases.SaveNudgUseCase
import chris.did.presentation.overview.usecases.SaveNudgUseCase.Params
import chris.did.presentation.usecase.Failure
import chris.did.presentation.usecase.UseCase.None
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/**
 * OverviewPresenter
 */
class OverviewPresenter(
    private val getNudgsUseCase: GetNudgsUseCase,
    private val saveNudgUseCase: SaveNudgUseCase,
    private val nudgViewModelFactory: NudgViewModelCreator,
    private val uiContext: CoroutineContext
) : BasePresenter<OverviewPresenterListener>(), OverviewPresentable {

    override fun getNudgs() {
        getNudgsUseCase.invoke(None()) { it.either(::onGetNudgsFailure, ::onGetNudgsSuccess) }
    }

    override fun saveNudg(nudgInput: String?) {
        if (nudgInput == null || nudgInput.isEmpty()) {
            presenterListener?.didFindInvalidNudgInput()
            return
        }
        presenterListener?.didFindValidNudgInput()
        saveNudgUseCase.invoke(Params(nudgInput)) {
            it.either(
                ::onSaveNudgFailure,
                ::onSaveNudgSuccess
            )
        }
    }

    // SaveNudgUseCase
    private fun onSaveNudgSuccess(none: None) {
        launch(uiContext) {
            presenterListener?.didSaveNudg()
        }
    }

    private fun onSaveNudgFailure(failure: Failure) {
        launch(uiContext) {
            presenterListener?.didFailToSaveNudg()
        }
    }

    // GetNudgsUseCase
    private fun onGetNudgsSuccess(nudgs: List<Nudg>) {
        val nudgViewModels = nudgViewModelFactory.create(nudgs)
        launch(uiContext) {
            presenterListener?.didGetNudgs(nudgViewModels)
        }
    }

    private fun onGetNudgsFailure(failure: Failure) {
        launch(uiContext) {
            presenterListener?.didFailToGetNudgs(Exception())
        }
    }
}
