package chris.did.nudg.overview

import chris.did.data.nudgservice.NudgServicable
import chris.did.nudg.base.BaseApplication
import chris.did.presentation.nudgfactory.NudgCreator
import chris.did.presentation.overview.OverviewPresentable
import chris.did.presentation.overview.OverviewPresenter
import chris.did.presentation.usecase.GetNudgsUseCase
import dagger.Module
import dagger.Provides
import kotlin.coroutines.experimental.CoroutineContext

/**
 * OverviewViewModelModule
 */
@Module
class OverviewViewModelModule {

    @Provides
    fun provideGetNudgsUseCase(
        nudgFactory: NudgCreator,
        nudgServicable: NudgServicable
    ): GetNudgsUseCase {
        return GetNudgsUseCase(nudgServicable, nudgFactory)
    }

    @Provides
    fun provideOverviewPresenter(
        getNudgsUseCase: GetNudgsUseCase,
        coroutineContext: CoroutineContext
    ): OverviewPresentable {
        return OverviewPresenter(getNudgsUseCase, coroutineContext)
    }

    @Provides
    fun provideOverviewViewModel(
        application: BaseApplication,
        presenter: OverviewPresentable
    ): OverviewViewModel {
        return OverviewViewModel(
            application,
            presenter
        )
    }
}