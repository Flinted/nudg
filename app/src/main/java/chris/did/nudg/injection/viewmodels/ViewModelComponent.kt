package chris.did.nudg.injection.viewmodels

import chris.did.nudg.nudgdetail.NudgDetailDialog
import chris.did.nudg.nudgdetail.NudgDetailViewModelModule
import chris.did.nudg.overview.OverviewActivity
import chris.did.nudg.overview.OverviewFragment
import chris.did.nudg.overview.OverviewViewModelModule
import dagger.Subcomponent

/**
 * ViewModelComponent
 */


@Subcomponent(modules = [ActivityModule::class, OverviewViewModelModule::class, NudgDetailViewModelModule::class])
interface ViewModelComponent {

    fun inject(overviewActivity: OverviewActivity)
    fun inject(overviewFragment: OverviewFragment)
    fun inject(nudgDetailDialog: NudgDetailDialog)
}
