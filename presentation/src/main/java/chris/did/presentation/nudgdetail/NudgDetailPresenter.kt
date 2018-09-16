package chris.did.presentation.nudgdetail

import chris.did.presentation.base.BasePresenter
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgdetail.usecases.GetNudgByIdUseCase
import chris.did.presentation.nudgviewmodelfactory.NudgViewModelCreator
import chris.did.presentation.usecase.Failure
import kotlinx.coroutines.experimental.launch
import java.util.*
import kotlin.coroutines.experimental.CoroutineContext

/**
 * NudgDetailPresenter
 */
class NudgDetailPresenter(
    private val nudgByIdUseCase: GetNudgByIdUseCase,
    private val nudgViewModelFactory: NudgViewModelCreator,
    private val uiContext: CoroutineContext
) : BasePresenter<NudgDetailPresenterListener>(), NudgDetailPresentable {

    override fun getNudgForId(id: UUID) {
        nudgByIdUseCase.invoke(id) {
            it.either(
                ::onGetNudgFailure,
                ::onGetNudgSuccess
            )
        }
    }

    private fun onGetNudgSuccess(nudg: Nudg) {
        val nudgViewModel = nudgViewModelFactory.create(nudg)
        launch(uiContext) {
            presenterListener?.onGetNudgSuccess(nudgViewModel)
        }
    }

    private fun onGetNudgFailure(failure: Failure) {
        launch(uiContext) {
            presenterListener?.onGetNudgFailure(Exception("Unable to retrieve nudg"))
        }
    }
}
