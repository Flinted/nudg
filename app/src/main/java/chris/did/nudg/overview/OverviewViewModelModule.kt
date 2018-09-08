package chris.did.nudg.overview

import chris.did.nudg.base.BaseApplication
import chris.did.presentation.overview.OverviewPresentable
import chris.did.presentation.overview.OverviewPresenter
import dagger.Module
import dagger.Provides

/**
 * OverviewViewModelModule
 */
@Module
class OverviewViewModelModule {

    @Provides
    fun provideOverviewViewModel(): OverviewPresentable {
        return OverviewPresenter()
    }

    @Provides
    fun provideSignInViewModel(
        application: BaseApplication,
        presenter: OverviewPresentable
    ): OverviewViewModel {
        return OverviewViewModel(
            application,
            presenter
        )
    }
}