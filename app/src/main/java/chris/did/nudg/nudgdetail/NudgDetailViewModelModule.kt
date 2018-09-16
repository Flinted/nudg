package chris.did.nudg.nudgdetail

import chris.did.data.nudgservice.NudgServicable
import chris.did.nudg.base.BaseApplication
import chris.did.presentation.nudgdetail.NudgDetailPresentable
import chris.did.presentation.nudgdetail.NudgDetailPresenter
import chris.did.presentation.nudgdetail.usecases.GetNudgByIdUseCase
import chris.did.presentation.nudgfactory.NudgCreator
import chris.did.presentation.nudgviewmodelfactory.NudgViewModelCreator
import dagger.Module
import dagger.Provides
import kotlin.coroutines.experimental.CoroutineContext

/**
 * NudgDetailViewModelModule
 */

@Module
class NudgDetailViewModelModule {

    @Provides
    fun provideGetNudgByIdUseCase(
        nudgService: NudgServicable,
        nudgFactory: NudgCreator
    ): GetNudgByIdUseCase {
        return GetNudgByIdUseCase(nudgService, nudgFactory)
    }

    @Provides
    fun provideNudgDetailPresenter(
        getNudgByIdUseCase: GetNudgByIdUseCase,
        nudgViewModelFactory: NudgViewModelCreator,
        uiContext: CoroutineContext
    ): NudgDetailPresentable {
        return NudgDetailPresenter(getNudgByIdUseCase, nudgViewModelFactory, uiContext)
    }

    @Provides
    fun provideNudgDetailViewModel(
        application: BaseApplication,
        presenter: NudgDetailPresentable
    ): NudgDetailViewModel {
        return NudgDetailViewModel(application, presenter)
    }
}
