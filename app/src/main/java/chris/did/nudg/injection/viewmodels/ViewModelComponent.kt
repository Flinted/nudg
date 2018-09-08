package chris.did.nudg.injection.viewmodels

import chris.did.nudg.overview.OverviewActivity
import chris.did.nudg.overview.OverviewViewModelModule
import dagger.Subcomponent

/**
 * ViewModelComponent
 */


@Subcomponent(modules = [ActivityModule::class, OverviewViewModelModule::class])
interface ViewModelComponent {

    fun inject(overviewActivity: OverviewActivity)
}
